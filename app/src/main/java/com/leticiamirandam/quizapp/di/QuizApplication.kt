package com.leticiamirandam.quizapp.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class QuizApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@QuizApplication)
            modules(listOf(networkModule, quizNetworkModule, domainModule, dataModule, presentationModule))
        }
    }
}