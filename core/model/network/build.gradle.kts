plugins {
    id("elegant.library")
    id("org.jetbrains.kotlin.android")
}

android.namespace = "com.unfunnyguy.elegant.core.model.network"

dependencies {
    implementation(libs.google.gson)
}