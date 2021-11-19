package com.sss.plugin

/**
 * @author mrzhang
 * @date 2021/11/17
 */
object Configuration {

    /**
     * 应用配置
     */
    object AppConfigs {
        /** 编译 sdk 版本*/
        const val compile_sdk_version = 29

        /** 最小支持版本 */
        const val min_sdk_version = 21

        /** 目标支持版本 */
        const val target_sdk_version = 29
    }

    private object AndroidXVersion {
        const val appcompat = "1.2.0"
        const val core_version = "1.3.2"
        const val leak_canary = "1.5.4"
        const val constraintlayout = "2.0.4"
        const val perimissionx = "1.6.1"
        /** lifecycle 版本*/
        const val lifecycle = "2.3.1"
    }

    object AndroidX {
        const val androidx_appcompat = "androidx.appcompat:appcompat:${AndroidXVersion.appcompat}"
        const val core_ktx = "androidx.core:core-ktx:${AndroidXVersion.core_version}"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:${AndroidXVersion.constraintlayout}"
        const val permissionx = "com.permissionx.guolindev:permission-support:${AndroidXVersion.perimissionx}"

        const val leak_canary_debug = "com.squareup.leakcanary:leakcanary-android:${AndroidXVersion.leak_canary}"
        const val leak_canary_release = "com.squareup.leakcanary:leakcanary-android-no-op:${AndroidXVersion.leak_canary}"
    }

    private object KotlinVersion {



    }

    object Kotlin {
        // livedata kotlin版本
        const val lifecycle_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${AndroidXVersion.lifecycle}"
    }
}