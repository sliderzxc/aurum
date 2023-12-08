import com.sliderzxc.gradle.android.setupAndroidLibrary

setupAndroidLibrary()

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("com.sliderzxc.gradle.setup")
}

dependencies {
    implementation("org.kodein.di:kodein-di:7.19.0")
}