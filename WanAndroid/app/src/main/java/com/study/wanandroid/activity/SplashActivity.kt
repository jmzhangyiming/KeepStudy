package com.study.wanandroid.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.study.wanandroid.R
import com.study.wanandroid.base.ui.BaseActivity
import com.study.wanandroid.viewmodel.BlankViewModel

class SplashActivity : BaseActivity() {

//    private val viewModel: BlankViewModel by viewModel()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        
    }


}