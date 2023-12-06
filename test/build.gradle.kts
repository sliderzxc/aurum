import com.sliderzxc.gradle.multiplatform.bundle.bundle
import com.sliderzxc.gradle.multiplatform.setupSourceSets

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    id("com.sliderzxc.gradle.setup")
}

//setupDefaults(
//    androidConfig = AndroidConfig(
//        21, 34, 31
//    ),
//)
//setupMultiplatform(
//    targets = {
//        this.jvm()
//        this.androidTarget()
//    }
//)
//setupMultiplatform(
//    targets = {
//        jvm()
//        js()
//    }
//)
kotlin {
    jvm()
//    jvm()
//    sourceSets {
//        val jvmMain by getting {
//            dependencies {
//                implementation("org.greenrobot:eventbus:3.3.1")
//            }
//        }
//    }
    setupSourceSets {
        val jvm by bundle()
        val js by bundle()

        js.main.dependencies {
            implementation("org.kodein.di:kodein-di:7.19.0")
        }

        jvm.main.dependencies {
            implementation("org.kodein.di:kodein-di:7.19.0")
            implementation("org.greenrobot:eventbus:3.3.1")
        }
    }
}

android {
    namespace = "com.sliderzxc.aurum.test"
}