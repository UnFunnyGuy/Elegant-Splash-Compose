pluginManagement {
    includeBuild("buildLogic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_PROJECT)
    repositories {
        google()
        maven ("https://jitpack.io")
        mavenCentral()
    }
}
rootProject.name = "Elegant Splash Compose"
include (":app")
include(":core:network")

