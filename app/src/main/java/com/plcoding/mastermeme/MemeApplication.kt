package com.plcoding.mastermeme

import android.app.Application
import com.plcoding.mastermeme.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MemeApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MemeApplication)
            modules(presentationModule)
        }

    }
}