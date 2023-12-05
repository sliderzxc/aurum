import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.android.library) apply false
    id("org.jetbrains.kotlinx.kover") version "0.6.1"
    id("org.jetbrains.dokka") version "1.9.10"
}

allprojects {
    group = "com.sliderzxc.aurum"
    version = "1.0.1"

    apply(plugin = "org.jetbrains.kotlinx.kover")
    apply(plugin = "org.jetbrains.dokka")
    apply(plugin = "maven-publish")
    apply(plugin = "signing")

    extensions.configure<PublishingExtension> {
        repositories {
            maven {
                val isSnapshot = version.toString().endsWith("SNAPSHOT")
                url = uri(
                    if (!isSnapshot) "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2"
                    else "https://s01.oss.sonatype.org/content/repositories/snapshots"
                )

                credentials {
                    username = gradleLocalProperties(rootDir).getProperty("sonatypeUsername")
                    password = gradleLocalProperties(rootDir).getProperty("sonatypePassword")
                }
            }
        }

        val javadocJar = tasks.register<Jar>("javadocJar") {
            dependsOn(tasks.dokkaHtml)
            archiveClassifier.set("javadoc")
            from("$buildDir/dokka")
        }

        publications {
            withType<MavenPublication> {
                artifact(javadocJar)
                pom {
                    name.set("aurum")
                    description.set("Kotlin Multiplatform Library for Logging")
                    url.set("https://github.com/sliderzxc/aurum")
                    licenses {
                        license {
                            name.set("GPL-3.0-only license")
                            url.set("https://opensource.org/license/gpl-3-0/")
                        }
                    }
                    issueManagement {
                        system.set("Github")
                        url.set("https://github.com/sliderzxc/aurum/issues")
                    }
                    scm {
                        connection.set("https://github.com/sliderzxc/aurum.git")
                        url.set("https://github.com/sliderzxc/aurum")
                    }
                    developers {
                        developer {
                            name.set("Vadym Hrynyk")
                            email.set("sliderzxc@gmail.com")
                        }
                    }
                }
            }
        }
    }

    val publishing = extensions.getByType<PublishingExtension>()
    extensions.configure<SigningExtension> {
        useInMemoryPgpKeys(
            "secret key",
            gradleLocalProperties(rootDir).getProperty("gpgKeyPassword"),
        )

        sign(publishing.publications)
    }

    // TODO: remove after https://youtrack.jetbrains.com/issue/KT-46466 is fixed
    project.tasks.withType(AbstractPublishToMaven::class.java).configureEach {
        dependsOn(project.tasks.withType(Sign::class.java))
    }
}

koverMerged {
    enable()
}