package com.study.kotlin.repository_app.data.di

import android.util.Log
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import org.koin.core.context.loadKoinModules
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.converter.gson.GsonConverterFactory

//For Koin injection

object DataModule {

    private const val OK_HTTP = "OK_HTTP"

    fun load() {
        loadKoinModules(networkModules() + repositoriesModule())
    }

    private fun networkModules(): Module {
        return module{
            single{
                val interceptor = HttpLoggingInterceptor {
                    Log.e(OK_HTTP, it)
                }
                interceptor.level = HttpLoggingInterceptor.Level.BODY

                OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .build()
            }

            single {
                GsonConverterFactory.create(GsonBuilder.create());
            }

            single {
                createService<GitHubService>(get(),get())
            }
        }
    }

}