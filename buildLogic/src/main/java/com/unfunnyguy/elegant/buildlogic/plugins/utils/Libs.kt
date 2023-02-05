package com.unfunnyguy.elegant.buildlogic.plugins.utils

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

internal fun Project.libs(): VersionCatalog {
    return extensions.getByType<VersionCatalogsExtension>().named("libs")
}

class LibsHolder {
    companion object {
        var libs: VersionCatalog? = null
    }
}
