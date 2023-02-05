package com.unfunnyguy.elegant.buildlogic

import com.unfunnyguy.elegant.buildlogic.plugins.utils.dependencyWrap
import com.unfunnyguy.elegant.buildlogic.plugins.utils.implementation
import com.unfunnyguy.elegant.buildlogic.plugins.utils.kapt
import org.gradle.api.Plugin
import org.gradle.api.Project

open class HiltPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.kapt")
                apply("dagger.hilt.android.plugin")
            }

            dependenciesWrap()
        }
    }

    open fun Project.dependenciesWrap() {
        dependencyWrap {
            implementation("hilt.android")
            kapt("hilt.compiler")
        }
    }
}
