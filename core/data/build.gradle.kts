plugins {
    id("elegant.library")
    id("elegant.hilt")
}

android.namespace = "com.unfunnyguy.core.data"

dependencies {
        implementation(project(":core:network"))
        implementation(project(":core:domain"))
        implementation(libs.androidx.paging.runtime)
}