package com.study.ui

import androidx.lifecycle.ViewModel
import com.study.base.log.InternalLog

abstract class BaseLibViewModel : ViewModel() {

    /**
     * 当这个ViewModel不再被使用时，这个方法将被调用并销毁。
     * 当ViewModel观察到一些数据，而您需要清除此订阅时，它很有用防止ViewModel的泄漏。
     */
    override fun onCleared() {
//        InternalLog.i("BaseLibViewModeel", "View onCleared ----> ViewModel: $this")
    }


}