package com.unfunnyguy.elegant.buildlogic

import com.unfunnyguy.elegant.buildlogic.plugins.configureLibrary
import org.gradle.api.Plugin
import org.gradle.api.Project

class LibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }
            configureLibrary()
        }
    }
}
