package com.example.koinguide

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger() // optional
            androidContext(this@MyApplication)
            modules(appModule, activityModule)
        }
    }
}