import com.sliderzxc.gradle.multiplatform.bundle.bundle
import com.sliderzxc.gradle.multiplatform.setupMultiplatform
import com.sliderzxc.gradle.multiplatform.setupSourceSets
import com.sliderzxc.gradle.publishing.setupPublishing

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    id("com.sliderzxc.gradle.setup")
}

setupMultiplatform()
setupPublishing()

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