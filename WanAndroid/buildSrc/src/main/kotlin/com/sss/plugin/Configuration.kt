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

    object Versions {
        const val appcompat = "1.2.0"
        const val core_version = "1.3.2"
        const val leak_canary = "1.5.4"
        const val constraintlayout = "2.0.4"
        const val perimissionx = "1.6.1"
        /** lifecycle 版本*/
        const val lifecycle = "2.3.1"
        /** activity 版本 */
        const val activity_version = "1.1.0"
        const val kotlin_version = "1.5.20"
        /** koin 版本 */
        const val koin_version = "2.2.1"

    }

    /**
     * 依赖
     */
    object Dependencies {
        const val androidx_appcompat = "androidx.appcompat:appcompat:${Versions.appcompat}"
        const val core_ktx = "androidx.core:core-ktx:${Versions.core_version}"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintlayout}"
        const val permissionx = "com.permissionx.guolindev:permission-support:${Versions.perimissionx}"

        const val leak_canary_debug = "com.squareup.leakcanary:leakcanary-android:${Versions.leak_canary}"
        const val leak_canary_release = "com.squareup.leakcanary:leakcanary-android-no-op:${Versions.leak_canary}"
        const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin_version}"
        // viewmodel kotlin版本
        const val lifecycle_viewmodel_ktx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
        // koin
        const val koin_scope = "org.koin:koin-androidx-scope:${Versions.koin_version}"
        // koin与viewmodel结合
        const val koin_viewmodel = "org.koin:koin-androidx-viewmodel:${Versions.koin_version}"
        // 扩展功能
        const val koin_ext = "org.koin:koin-androidx-ext:${Versions.koin_version}"
        /** androidx activity */
        const val androidx_activity = "androidx.activity:activity:${Versions.activity_version}"
        const val androidx_activity_ktx = "androidx.activity:activity-ktx:${Versions.activity_version}"

        /** androidx material */
        const val androidx_material = "com.google.android.material:material:1.2.1"
    }
}