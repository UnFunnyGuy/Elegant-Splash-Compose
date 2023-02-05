package com.unfunnyguy.elegant.buildlogic

import com.unfunnyguy.elegant.buildlogic.plugins.utils.dependencyWrap
import com.unfunnyguy.elegant.buildlogic.plugins.utils.implementation
import com.unfunnyguy.elegant.buildlogic.plugins.utils.kapt
import org.gradle.api.Project

class HiltNavPlugin: HiltPlugin() {

    override fun Project.dependenciesWrap() {
        dependencyWrap{
            implementation("hilt.android")
            implementation("hilt.navigation.compose")
            kapt("hilt.compiler")
        }
    }

}