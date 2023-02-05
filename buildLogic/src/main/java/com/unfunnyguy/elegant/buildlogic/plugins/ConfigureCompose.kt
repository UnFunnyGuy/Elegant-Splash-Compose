package com.unfunnyguy.elegant.buildlogic.plugins

import com.android.build.api.dsl.CommonExtension
import com.unfunnyguy.elegant.buildlogic.plugins.utils.libs
import org.gradle.api.Project

internal fun Project.configureCompose(
    commonExtension: CommonExtension<*, *, *, *>,
) {
    commonExtension.apply {
        buildFeatures { compose = true }
        composeOptions {
            kotlinCompilerExtensionVersion = libs().findVersion("composeCompiler").get().toString()
        }
    }
}
