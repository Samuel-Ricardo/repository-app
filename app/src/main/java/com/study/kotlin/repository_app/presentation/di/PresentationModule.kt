package com.study.kotlin.repository_app.presentation.di

import org.koin.core.context.loadKoinModules

class PresentationModule {

    fun load() {
        loadKoinModules(viewModelModule())
    }
}