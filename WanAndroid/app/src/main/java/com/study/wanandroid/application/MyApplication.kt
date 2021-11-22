package com.study.wanandroid.application

import android.app.Application
import com.study.wanandroid.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

/**
 * @author mrzhang
 * @date 2021/11/21
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // 初始化koin
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@MyApplication)
            modules(listOf(viewModelModule))
        }
    }
}