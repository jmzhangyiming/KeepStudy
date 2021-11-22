package com.study.wanandroid.activity

import android.content.Context
import com.study.base.ext.startTargetActivity
import com.study.wanandroid.base.ui.BaseActivity

class MainActivity : BaseActivity() {

    companion object {
        fun actionStart(context: Context) {
            context.startTargetActivity<MainActivity>()
        }
    }

}