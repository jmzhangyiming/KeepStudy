package com.study.base.log


/**
 * 内部使用日志打印
 */
class InternalLog {

    private var logEnable = false

    fun i(tag: String?, message: String, vararg args: Any) {
        if (logEnable) {

        }
    }
}

interface Printer {
    fun log(priority: Int, tag: String?, message: String, throwable: Throwable?)

    companion object {
        val DEFAULT_PRINTER:Printer = object : Printer {
            override fun log(priority: Int, tag: String?, message: String, throwable: Throwable?) {
                var msg = message.orEmpty()
                if (throwable != null && message != null) {
//                    msg += " : " + throwable.
                }
            }

        }

    }
}
