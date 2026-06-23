group = "dev.fluttercommunity.plus.device_info"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    id("com.android.library")
}

val builtInKotlinEnabled = project.findProperty("android.builtInKotlin")?.toString()?.toBoolean() ?: false
if (!builtInKotlinEnabled) {
    apply(plugin = "org.jetbrains.kotlin.android")
}

kotlin {
    jvmToolchain(17)
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17)
    }
}

android {
    namespace = "dev.fluttercommunity.plus.device_info"
    compileSdk = flutter.compileSdkVersion

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    defaultConfig {
        minSdk = 19
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    lint {
        disable.addAll(listOf("InvalidPackage", "MissingPermission"))
    }
}

dependencies {
    implementation("androidx.annotation:annotation:1.9.1")
}
