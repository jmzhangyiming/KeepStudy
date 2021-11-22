package com.study.base.ext

import android.app.Activity
import android.content.Context
import android.content.Intent

/**
 * 执行 [bundles] 方法块配置 [Intent] 后，通过 [Context] 对象，打开类型为 [A] 的 [Activity] 界面，并传递 [options]
 * > [bundles] 默认空实现
 *
 * > [options] 启动配置相关，默认 `null`
 *
 * > [Context] 对象若不是 [Activity]，则会调用 [Intent.addFlags] ([Intent.FLAG_ACTIVITY_NEW_TASK])
 * 在新的栈中打开
 */
inline fun <reified A: Activity> Context.startTargetActivity() {

}