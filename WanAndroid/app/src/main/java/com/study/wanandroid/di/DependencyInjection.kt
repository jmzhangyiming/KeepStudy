package com.study.wanandroid.di

import com.study.wanandroid.viewmodel.BlankViewModel
import org.koin.androidx.experimental.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

/** ViewModel Module */
val viewModelModule: Module = module {
    viewModel {BlankViewModel()}
}