package com.unfunnyguy.elegant.buildlogic

import com.google.devtools.ksp.gradle.KspExtension
import com.unfunnyguy.elegant.buildlogic.plugins.utils.dependencyWrap
import com.unfunnyguy.elegant.buildlogic.plugins.utils.implementation
import com.unfunnyguy.elegant.buildlogic.plugins.utils.ksp
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure


class DestinationsPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        val pluginExt = Extension(target)
        println("moduleName::${target.name}")
        with(target) {
            target.extensions.add("destinations", pluginExt)
            with(pluginManager) {
                if (!hasPlugin("com.google.devtools.ksp")) {
                    apply("com.google.devtools.ksp")
                }
            }

            extensions.configure<KspExtension> {
                arg("compose-destinations.mode", pluginExt.destinationsMode)
                arg("compose-destinations.moduleName", pluginExt.moduleName)
            }

            dependencyWrap {
                implementation("compose-destination")
                ksp("compose-destination-ksp")
            }
        }
    }

    //why not?
    class Extension(project: Project) {
        var destinationsMode: String = "navgraphs"
        var moduleName: String = project.name
    }

}




