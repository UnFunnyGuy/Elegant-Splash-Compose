package com.unfunnyguy.elegant.buildlogic

import com.unfunnyguy.elegant.buildlogic.plugins.configureApplication
import org.gradle.api.Plugin
import org.gradle.api.Project

class ApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }
            configureApplication()
        }
    }
}

object BuildConfig {
    const val compileSdkVersionInt = 33
    const val minSdkVersion = 24
    const val targetSdkVersion = 33
    const val versionCode = 2
    const val versionName = "0.0.1"
    const val packageName = "com.unfunnyguy.elegant"
}
