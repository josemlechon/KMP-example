plugins {
    kotlin("multiplatform")
    id("com.google.devtools.ksp") version "1.9.10-1.0.13"
    id("com.android.library")
    id("kotlinx-serialization")
}

apply("../tools/detekt.gradle")
tasks.named("check").configure {
    this.setDependsOn(this.dependsOn.filterNot {
        it is TaskProvider<*> && it.name == "detekt"
    })
}

repositories {
    mavenCentral()
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    androidTarget {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(libs.ktor.client.core)
                implementation(libs.ktor.client.negotiation)
                implementation(libs.ktor.client.json)
                implementation(libs.ktor.client.logging)
                implementation(libs.kotlinx.coroutines.core)

                implementation(libs.logging.napier)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))

                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))

                implementation(libs.testing.ktor)
                implementation(libs.testing.kotlin)
                implementation(libs.testing.mockactive)
            }
        }

        val androidMain by getting {
            dependencies {
                implementation(libs.ktor.client.okhttp)
            }
        }

        val iosMain by getting {
            dependencies {
                implementation(libs.ktor.client.darwin)
            }
        }
    }
}

dependencies {
    configurations
        .filter { it.name.startsWith("ksp") && it.name.contains("Test") }
        .forEach {
            add(it.name, libs.testing.mockactive)
        }
}

android {
    namespace = "com.jml.example.app"
    compileSdk = 33
    defaultConfig {
        minSdk = 24
    }
}