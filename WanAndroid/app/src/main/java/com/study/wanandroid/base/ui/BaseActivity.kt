package com.study.wanandroid.base.ui

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.google.android.material.transition.platform.MaterialSharedAxis
import com.study.ui.activity.BaseBindingLibActivity
import com.study.wanandroid.constants.ACTIVITY_ANIM_DURATION

abstract class BaseActivity : BaseBindingLibActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        beforeOnCreate()
        super.onCreate(savedInstanceState)
    }
    /** [onCreate]之前执行，可用于配置动画 */
    protected open fun beforeOnCreate() {
        // 使用Material建立activity进入和返回动画
        window.run {
            enterTransition = MaterialSharedAxis(MaterialSharedAxis.X, true).apply {
                duration = ACTIVITY_ANIM_DURATION
            }

            exitTransition = MaterialSharedAxis(MaterialSharedAxis.X, false).apply {
                duration = ACTIVITY_ANIM_DURATION
            }
        }
    }
}