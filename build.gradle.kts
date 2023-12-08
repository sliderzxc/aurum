import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties
import com.sliderzxc.gradle.android.config.AndroidConfig
import com.sliderzxc.gradle.defaults.setupDefaults
import com.sliderzxc.gradle.multiplatform.config.MultiplatformConfig
import com.sliderzxc.gradle.multiplatform.platforms.Platform
import com.sliderzxc.gradle.publishing.config.DeveloperConfig
import com.sliderzxc.gradle.publishing.config.LibraryConfig
import com.sliderzxc.gradle.publishing.config.PublishingConfig
import com.sliderzxc.gradle.publishing.platforms.multiplatform.applySigningPlugin

plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    id("org.jetbrains.kotlinx.kover") version "0.6.1"
    id("org.jetbrains.dokka") version "1.9.10"
    id("com.sliderzxc.gradle.setup")
}

setupDefaults(
    MultiplatformConfig(
        setOf(
            Platform.Android,
            Platform.Jvm,
            Platform.Js
        )
    ),
    AndroidConfig(
        minSdkVersion = 21,
        compileSdkVersion = 34,
        targetSdkVersion = 34,
        namespace = "com.sliderzxc.aurum.test"
    ),
    PublishingConfig(
        LibraryConfig(
            group = "com.sliderzxc.aurum",
            version = "1.0.3",
            name = "aurum",
            description = "Kotlin Multiplatform Library for Logging",
            url = "https://github.com/sliderzxc/aurum",
            scmUrl = "https://github.com/sliderzxc/aurum.git",
            releaseRepository = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2",
            snapshotRepository = "https://s01.oss.sonatype.org/content/repositories/snapshots",
            licenseName = "GPL-3.0-only license",
            licenseUrl = "https://opensource.org/license/gpl-3-0/",
            signingKey = gradleLocalProperties(rootDir).getProperty("gpgKeySecret"),
            signingPassword = gradleLocalProperties(rootDir).getProperty("gpgKeyPassword"),
        ),
        DeveloperConfig(
            id = "sliderzxc",
            name = "Vadym Hrynyk",
            email  = "sliderzxc@gmail.com",
            username = gradleLocalProperties(rootDir).getProperty("sonatypeUsername"),
            password = gradleLocalProperties(rootDir).getProperty("sonatypePassword")
        )
    )
)

koverMerged {
    enable()
}