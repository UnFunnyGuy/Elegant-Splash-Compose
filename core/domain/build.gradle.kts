plugins {
    id("elegant.library")
    id("elegant.hilt")
}

android.namespace = "com.unfunnyguy.core.domain"

dependencies {
    implementation(libs.androidx.paging.runtime)
    api(project(":core:model:domain"))
}