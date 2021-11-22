package com.study.wanandroid.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.study.wanandroid.R
import com.study.wanandroid.base.ui.BaseActivity
import com.study.wanandroid.constants.SPLASH_DELAY_MS
import com.study.wanandroid.viewmodel.BlankViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity() {

    private val viewModel: BlankViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        lifecycleScope.launch {
            // 延时 1000ms
            delay(SPLASH_DELAY_MS)
            // 跳转主界面
            MainActivity.actionStart(mContext)
            // 结束当前界面
            finish()
        }
    }




}