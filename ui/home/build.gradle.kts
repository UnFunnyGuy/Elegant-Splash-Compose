plugins {
    id("elegant.library")
    id("elegant.compose")
    id("elegant.hilt.nav")
    id("elegant.destinations")
}

android.namespace = "com.unfunnyguy.elegant.ui.home"

dependencies {
    implementation(project(":core:ui"))
    implementation(project(":core:domain"))
    implementation(project(":core:data"))
}