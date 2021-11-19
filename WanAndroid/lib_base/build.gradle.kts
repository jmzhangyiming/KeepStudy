import com.sss.plugin.Configuration
plugins {
    id ("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    // 编译sdk版本
    compileSdkVersion(Configuration.AppConfigs.compile_sdk_version)

    // 资源前缀
    resourcePrefix("base")

    defaultConfig {
        // 最低支持版本
        minSdkVersion(Configuration.AppConfigs.min_sdk_version)
        // 目标 SDK 版本
        targetSdkVersion(Configuration.AppConfigs.target_sdk_version)
    }

    // Java 版本配置
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    // 源文件路径设置
    sourceSets {
        named("main") {
            // 指定java源文件目录为src/main/java和src/main/kotlin
            java.srcDirs("src/main/java", "src/main/kotlin")
            jni.srcDirs("libs", "jniLibs")
        }
    }

//    buildFeatures {
//        // DataBinding 开启
//        dataBinding = true
//    }
}

dependencies {
    api(project(":lib_base"))


}