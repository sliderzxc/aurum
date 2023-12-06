import com.sliderzxc.gradle.multiplatform.bundle.bundle
import com.sliderzxc.gradle.multiplatform.platforms.Platform
import com.sliderzxc.gradle.multiplatform.setupMultiplatform
import com.sliderzxc.gradle.multiplatform.setupSourceSets

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    id("com.sliderzxc.gradle.setup")
}

setupMultiplatform(
    Platform.Android,
    Platform.Jvm,
    Platform.Js
)

kotlin {
    setupSourceSets {
        val android by bundle()
        val jvm by bundle()
        val js by bundle()
        val common by bundle()

        android.main.dependencies {
            implementation("org.kodein.di:kodein-di:7.19.0")
        }

        jvm.main.dependencies {
            implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.5.0")
        }

        js.main.dependencies {
            implementation("app.softwork:kotlinx-uuid-core:0.0.22")
        }

        common.main.dependencies {
            implementation("it.czerwinski:kotlin-util:1.9.1")
        }
    }
}

android {
    namespace = "com.sliderzxc.aurum.android"
    compileSdk = 34

    defaultConfig {
        minSdk = 21
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}