package com.wj.sampleproject.viewmodel

import android.view.MenuItem
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import cn.wj.android.base.ext.string
import cn.wj.common.ext.condition
import com.orhanobut.logger.Logger
import com.wj.sampleproject.R
import com.wj.sampleproject.base.viewmodel.BaseViewModel
import com.wj.sampleproject.constants.DATA_CACHE_KEY_USER_NAME
import com.wj.sampleproject.constants.PASSWORD_MIN_LENGTH
import com.wj.sampleproject.ext.defaultFaildBlock
import com.wj.sampleproject.ext.judge
import com.wj.sampleproject.helper.UserInfoData
import com.wj.sampleproject.model.ProgressModel
import com.wj.sampleproject.model.UiCloseModel
import com.wj.sampleproject.repository.UserRepository
import com.wj.sampleproject.tools.decodeString
import com.wj.sampleproject.tools.encode
import com.wj.sampleproject.tools.toSnackbarModel
import kotlinx.coroutines.launch

/**
 * 登录 ViewModel，注入 [repository] 获取数据
 *
 * - 创建时间：2019/10/14
 *
 * @author 王杰
 */
class LoginViewModel(
        private val repository: UserRepository
) : BaseViewModel() {

    /** 控制进度条弹窗显示  */
    val progressData = MutableLiveData<ProgressModel>()

    /** 指纹登录数据 */
    val fingerprintData = MutableLiveData<Int>()

    /** 标记 - 是否是注册 */
    val register: MutableLiveData<Boolean> = MutableLiveData(true)

    /** 用户名 */
    val userName: ObservableField<String> = ObservableField(DATA_CACHE_KEY_USER_NAME.decodeString())

    /** 用户名错误文本 */
    val userNameError: ObservableField<String> = ObservableField<String>()

    /** 密码 */
    val password: ObservableField<String> = ObservableField<String>()

    /** 密码错误文本 */
    val passwordError: ObservableField<String> = object : ObservableField<String>(password) {
        override fun get(): String? {
            val get = password.get()
            if (!get.isNullOrBlank() && get.length >= PASSWORD_MIN_LENGTH) {
                return ""
            }
            return super.get()
        }
    }

    /** 再次输入密码 */
    val repassword: ObservableField<String> = ObservableField<String>()

    /** 密码错误文本 */
    val repasswordError: ObservableField<String> = object : ObservableField<String>(repassword) {
        override fun get(): String? {
            val get = repassword.get()
            if (!get.isNullOrBlank() && get.length >= PASSWORD_MIN_LENGTH && get == password.get()) {
                return ""
            }
            return super.get()
        }
    }

    /** 按钮文本 */
    val buttonStr: LiveData<String> = register.map { isRegister ->
        if (isRegister) {
            // 注册
            R.string.app_register
        } else {
            // 登录
            R.string.app_login
        }.string
    }

    /** 标记 - 是否显示指纹登录 */
    val showFingerprint: ObservableBoolean = ObservableBoolean()

    /** 关闭点击 */
    val onCloseClick: (MenuItem) -> Boolean = {
        if (it.itemId == R.id.menu_close) {
            // 关闭
            uiCloseData.value = UiCloseModel()
        }
        false
    }

    /** 注册、登录点击 */
    val onTabClick: (Boolean) -> Unit = { registerClick ->
        register.value = registerClick
    }

    /** 按钮点击 */
    val onButtonClick: () -> Unit = fun() {
        if (userName.get().isNullOrBlank()) {
            // 用户名为空
            userNameError.set(R.string.app_please_enter_user_name.string)
            return
        }
        if (password.get().isNullOrBlank()) {
            // 密码为空
            passwordError.set(R.string.app_password_must_not_be_empty.string)
            return
        }
        if (password.get().orEmpty().length < PASSWORD_MIN_LENGTH) {
            // 密码长度小于最低长度
            passwordError.set(R.string.app_password_length_must_larger_than_six.string)
            return
        }
        if (register.value.condition) {
            // 注册
            if (repassword.get().isNullOrBlank()) {
                // 密码为空
                repasswordError.set(R.string.app_password_must_not_be_empty.string)
                return
            }
            if (repassword.get().orEmpty().length < PASSWORD_MIN_LENGTH) {
                // 密码长度小于最低长度
                repasswordError.set(R.string.app_password_length_must_larger_than_six.string)
                return
            }
            if (repassword.get() != password.get()) {
                // 密码不匹配
                repasswordError.set(R.string.app_re_set_password_not_match.string)
                return
            }
        }
        if (register.value.condition) {
            // 注册
            register()
        } else {
            // 登录
            login()
        }
    }

    /** 指纹登录点击 */
    val onFingerprintClick: () -> Unit = {
        fingerprintData.value = 0
    }

    /** 注册 */
    private fun register() {
        viewModelScope.launch {
            try {
                // 显示进度条弹窗
                progressData.value = ProgressModel(cancelable = false)
                repository.register(userName.get().orEmpty(), password.get().orEmpty())
                        .judge(onSuccess = {
                            // 注册成功，保存用户信息
                            UserInfoData.value = data
                            DATA_CACHE_KEY_USER_NAME.encode(userName.get().orEmpty())
                            // 关闭当前界面
                            uiCloseData.value = UiCloseModel()
                        }, onFailed = defaultFaildBlock)
            } catch (throwable: Throwable) {
                // 打印错误日志
                Logger.t("NET").e(throwable, "register")
                snackbarData.value = throwable.toSnackbarModel()
            } finally {
                // 隐藏进度条弹窗
                progressData.value = null
            }
        }
    }

    /** 登录 */
    private fun login() {
        viewModelScope.launch {
            try {
                // 显示进度条弹窗
                progressData.value = ProgressModel(cancelable = false)
                repository.login(userName.get().orEmpty(), password.get().orEmpty())
                        .judge(onSuccess = {
                            // 登录成功，保存用户信息
                            UserInfoData.value = data
                            DATA_CACHE_KEY_USER_NAME.encode(userName.get().orEmpty())
                            // 关闭当前界面
                            uiCloseData.value = UiCloseModel()
                        }, onFailed = defaultFaildBlock)
            } catch (throwable: Throwable) {
                // 打印错误日志
                Logger.t("NET").e(throwable, "login")
                snackbarData.value = throwable.toSnackbarModel()
            } finally {
                // 隐藏进度条弹窗
                progressData.value = null
            }
        }
    }
}