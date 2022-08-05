package com.study.openlibs

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.study.kotlinstudy.R
import com.study.kotlinstudy.User
import com.study.kotlinstudy.databinding.ActivityMainBinding
import com.study.openlibs.databinding.UserBean

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.user = UserBean("111", "222", "333")

    }

}