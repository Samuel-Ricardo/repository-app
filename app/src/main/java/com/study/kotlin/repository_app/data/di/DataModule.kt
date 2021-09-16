package com.study.kotlin.repository_app.data.di

import org.koin.core.context.loadKoinModules

//For Koin injection

object DataModule {

    private const val OK_HTTP = "OkHttp"

    fun load() {
        loadKoinModules(networkModules() + repositoriesModule())
    }

}