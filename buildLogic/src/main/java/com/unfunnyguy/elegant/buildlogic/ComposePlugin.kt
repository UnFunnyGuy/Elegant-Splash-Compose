package com.unfunnyguy.elegant.buildlogic

import com.android.build.api.dsl.LibraryExtension
import com.unfunnyguy.elegant.buildlogic.plugins.configureCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class ComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {

            extensions.configure<LibraryExtension>{
                configureCompose(this)
            }

        }
    }
}
