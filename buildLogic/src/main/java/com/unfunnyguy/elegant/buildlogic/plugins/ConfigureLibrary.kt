package com.unfunnyguy.elegant.buildlogic.plugins

import com.android.build.api.dsl.CommonExtension
import com.android.build.gradle.LibraryExtension
import com.unfunnyguy.elegant.buildlogic.BuildConfig
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.gradle.kotlin.dsl.configure
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions

internal fun Project.configureLibrary() {
    extensions.configure<LibraryExtension> {
        compileSdk = BuildConfig.compileSdkVersionInt

        defaultConfig.targetSdk = BuildConfig.targetSdkVersion
        defaultConfig.minSdk = BuildConfig.minSdkVersion
        defaultConfig.consumerProguardFiles("consumer-rules.pro")

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()

        }

    }

    extensions.configure<KotlinAndroidProjectExtension>{
        jvmToolchain(8)
    }

}

fun CommonExtension<*, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}
