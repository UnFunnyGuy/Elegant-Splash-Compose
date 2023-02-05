package com.unfunnyguy.elegant.buildlogic.plugins.utils

import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.dependencies


internal fun Project.dependencyWrap(dependencyHandlerScope: DependencyHandlerScope. () -> Unit){
    dependencies {
        LibsHolder.libs = libs()
        dependencyHandlerScope()
    }
}

internal fun DependencyHandlerScope.implementation(alias: String){
    add("implementation", LibsHolder.libs?.findLibrary(alias)?.get()!!)
}

internal fun DependencyHandlerScope.kapt(alias: String){
    add("kapt", LibsHolder.libs?.findLibrary(alias)?.get()!!)
}

internal fun DependencyHandlerScope.ksp(alias: String){
    add("ksp", LibsHolder.libs?.findLibrary(alias)?.get()!!)
}


