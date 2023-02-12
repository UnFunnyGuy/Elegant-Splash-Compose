plugins {
    id("elegant.library")
    id("elegant.compose")
}

android.namespace = "com.unfunnyguy.elegant.core.ui"

dependencies {
    api(project(":core:model:domain"))
    api(libs.accompanist.pager)
    api(libs.accompanist.pager.indicators)
    api(libs.androidx.paging.runtime)
    api(libs.androidx.paging.compose)
    api(libs.kotlinx.collections.immutable)
    api(libs.lifecycle.runtimeCompose)
    api(libs.androidx.activity.compose)
    api(libs.coil.kt.compose)
    api(libs.compose.ui)
    api(libs.compose.ui.graphics)
    api(libs.compose.ui.tooling.preview)
    api(libs.compose.material3)
    androidTestApi(libs.compose.ui.test)
    debugApi(libs.compose.ui.tooling)
    debugApi(libs.compose.ui.testManifest)
}
