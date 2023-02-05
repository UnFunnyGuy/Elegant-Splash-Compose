package com.unfunnyguy.elegant.buildlogic.plugins

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.unfunnyguy.elegant.buildlogic.BuildConfig
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal fun Project.configureApplication() {

    extensions.configure<BaseAppModuleExtension> {
        namespace = BuildConfig.packageName
        compileSdk = BuildConfig.compileSdkVersionInt

        defaultConfig {
            targetSdk = BuildConfig.targetSdkVersion
            applicationId = BuildConfig.packageName
            minSdk = BuildConfig.minSdkVersion
            targetSdk = BuildConfig.targetSdkVersion
            versionCode = BuildConfig.versionCode
            versionName = BuildConfig.versionName
        }

        configureBuildTypes()

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }

        configureCompose(this)

        kotlinOptions { jvmTarget = JavaVersion.VERSION_1_8.toString() }


    }
}
