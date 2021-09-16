package com.study.kotlin.repository_app

import android.app.Application
import android.app.Presentation
import com.study.kotlin.repository_app.data.di.DataModule
import com.study.kotlin.repository_app.domain.di.DomainModule
import com.study.kotlin.repository_app.presentation.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin


class App: Application() {

    override fun onCreate() {
        super.onCreate()

        setupKoin();
    }

    private fun setupKoin() {
        startKoin{
            androidContext(this@App)
        }

        DataModule.load();
        DomainModule.load();
        PresentationModule.load();
    }
}