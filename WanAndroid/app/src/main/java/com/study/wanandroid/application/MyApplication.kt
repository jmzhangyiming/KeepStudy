package com.study.wanandroid.application

import android.app.Application
import org.koin.core.context.startKoin

/**
 * @author mrzhang
 * @date 2021/11/21
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // 初始化koin
        startKoin {

        }
    }
}