package com.study.kotlin.repository_app.domain.di

import org.koin.core.context.loadKoinModules

object DomainModule {

    fun load(){
        loadKoinModules(useCaseModule())
    }
}