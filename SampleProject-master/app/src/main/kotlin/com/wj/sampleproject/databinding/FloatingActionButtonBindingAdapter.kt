package com.wj.sampleproject.databinding

import androidx.databinding.BindingAdapter
import cn.wj.common.ext.condition
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

/**
 * FloatingActionButton DataBinding 适配器
 *
 * - 创建时间：2021/1/18
 *
 * @author 王杰
 */

/**
 * 设置 [efab] 是否展开 [extend]
 */
@BindingAdapter("android:bind_efab_extend")
fun setExtendedFloatingActionButtonStrategy(efab: ExtendedFloatingActionButton, extend: Boolean?) {
    if (extend.condition) {
        efab.extend()
    } else {
        efab.shrink()
    }
}