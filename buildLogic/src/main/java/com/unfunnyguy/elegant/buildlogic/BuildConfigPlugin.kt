package com.unfunnyguy.elegant.buildlogic

import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.Properties

class BuildConfigPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val baseUrl = getLocalProperty("baseUrl")

            extensions.configure<LibraryExtension> {
                buildFeatures.buildConfig = true
                buildTypes {
                    getByName("debug") {
                        buildConfigField("String", "BASE_API_URL", baseUrl.toString())
                    }

                    getByName("release") {
                        buildConfigField("String", "BASE_API_URL", baseUrl.toString())
                    }
                }
            }
        }
    }
}

private fun Project.getLocalProperty(key: String, file: String = "local.properties"): Any {
    val properties = Properties()
    val localProperties = File(file)
    if (localProperties.isFile) {
        InputStreamReader(FileInputStream(localProperties), Charsets.UTF_8).use { reader ->
            properties.load(reader)
        }
    } else error("File from not found")

    return properties.getProperty(key)
}