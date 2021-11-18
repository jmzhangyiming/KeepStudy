package com.sss.plugin

/**
 * @author mrzhang
 * @date 2021/11/17
 */
object Configuration {
    private object AndroidXVersion {
        val appcompat = "1.2.0"
        val core_version = "1.3.2"
        val leak_canary = "1.5.4"
        val constraintlayout = "2.0.4"
        val perimissionx = "1.6.1"
        /** lifecycle 版本*/
        val lifecycle = "2.3.1"
    }

    object AndroidX {
        val appcompat = "androidx.appcompat:appcompat:${AndroidXVersion.appcompat}"
        val core_ktx = "androidx.core:core-ktx:${AndroidXVersion.core_version}"
        val constraintlayout = "androidx.constraintlayout:constraintlayout:${AndroidXVersion.constraintlayout}"
        val permissionx = "com.permissionx.guolindev:permission-support:${AndroidXVersion.perimissionx}"

        val leak_canary_debug = "com.squareup.leakcanary:leakcanary-android:${AndroidXVersion.leak_canary}"
        val leak_canary_release = "com.squareup.leakcanary:leakcanary-android-no-op:${AndroidXVersion.leak_canary}"
    }

    object KotlinVersion {



    }

    object Kotlin {
        // livedata kotlin版本
        val lifecycle_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${AndroidXVersion.lifecycle}"
    }
}