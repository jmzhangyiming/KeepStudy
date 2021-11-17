package com.sss.plugin

/**
 * @author mrzhang
 * @date 2021/11/16
 */
private object AndroidXVersion {
    val appcompat = "1.2.0"
    val core_version = "1.3.2"
    val leak_canary = "1.5.4"
    val constraintlayout = "2.0.4"
}

object AndroidX {
    val appcompat = "androidx.appcompat:appcompat:${AndroidXVersion.appcompat}"
    val core_ktx = "androidx.core:core-ktx:${AndroidXVersion.core_version}"
    val constraintlayout = "androidx.constraintlayout:constraintlayout:${AndroidXVersion.constraintlayout}"

    val leak_canary_debug = "com.squareup.leakcanary:leakcanary-android:${AndroidXVersion.leak_canary}"
    val leak_canary_release = "com.squareup.leakcanary:leakcanary-android-no-op:${AndroidXVersion.leak_canary}"
}

