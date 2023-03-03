plugins {
    id("elegant.application")
    id("elegant.hilt.nav")
    id("elegant.destinations")
}




dependencies {

    implementation(project(":ui:home"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.lifecycle.runtimeCompose)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.paging.runtime)
    implementation(libs.androidx.paging.compose)
    implementation(libs.coil.kt.compose)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.graphics)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    testImplementation(libs.test.junit)
    androidTestImplementation(libs.test.ext)
    androidTestImplementation(libs.test.espresso.core)
    androidTestImplementation(libs.compose.ui.test)
    debugImplementation(libs.compose.ui.tooling)
    debugImplementation(libs.compose.ui.testManifest)




}
