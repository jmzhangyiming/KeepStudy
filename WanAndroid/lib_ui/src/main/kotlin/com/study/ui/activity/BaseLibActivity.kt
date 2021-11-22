package com.study.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


abstract class BaseLibActivity : AppCompatActivity(){

    /** 当前界面 Context 对象*/
    protected lateinit var mContext: AppCompatActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 保存当前 Context 对象
        mContext = this
    }

}