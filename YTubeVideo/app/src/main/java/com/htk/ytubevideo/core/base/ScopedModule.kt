package com.htk.ytubevideo.core.base

import org.koin.core.module.Module

abstract class ScopedModule {
    abstract fun getPresentation(): Module
    abstract fun getAdditionalModules(): Module?
    abstract fun getDomain(): Module?
    abstract fun get(): List<Module>
    fun start(moduleName: String) {
        println(moduleName + " Inject: " + get().size + " dependencies")
    }
}