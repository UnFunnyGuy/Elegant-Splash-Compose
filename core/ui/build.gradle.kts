plugins {
    id("elegant.library")
    id("elegant.compose")
}

android.namespace = "com.unfunnyguy.elegant.core.ui"

dependencies {
    implementation(project(":core:model:domain"))

    implementation(libs.lifecycle.runtimeCompose)
    implementation(libs.androidx.activity.compose)
    implementation(libs.coil.kt.compose)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    androidTestImplementation(libs.compose.ui.test)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.testManifest)
}
