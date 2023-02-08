plugins { `kotlin-dsl` }

val basePluginName = "elegant"
val basePluginPackageName = "com.unfunnyguy.elegant.buildlogic"

repositories { // required by kotlin-dsl plugin dependencies
    mavenCentral()
    google()
}

dependencies {
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.android.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("application-plugin") {
            id = "$basePluginName.application"
            implementationClass = "$basePluginPackageName.ApplicationPlugin"
        }
        register("library-plugin") {
            id = "$basePluginName.library"
            implementationClass = "$basePluginPackageName.LibraryPlugin"
        }
        register("hilt-plugin") {
            id = "$basePluginName.hilt"
            implementationClass = "$basePluginPackageName.HiltPlugin"
        }
        register("hilt-nav-plugin") {
            id = "$basePluginName.hilt.nav"
            implementationClass = "$basePluginPackageName.HiltNavPlugin"
        }
        register("build-config-plugin") {
            id = "$basePluginName.buildConfig"
            implementationClass = "$basePluginPackageName.BuildConfigPlugin"
        }
    }
}
