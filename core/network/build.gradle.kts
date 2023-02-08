plugins {
    id("elegant.library")
    id("elegant.buildConfig")
    id("elegant.hilt")
}


android.namespace = "com.unfunnyguy.elegant.core.network"

dependencies {
    implementation(project(":core:model"))
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging.interceptor)
}
