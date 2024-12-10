package com.plcoding.mastermeme.core

import android.app.Application
import com.plcoding.mastermeme.core.di.domainModule
import com.plcoding.mastermeme.core.di.presentationModule
import com.plcoding.mastermeme.feature_editor.di.featureEditorModule
import com.plcoding.mastermeme.feature_templates.di.featureTemplatesModule
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
            modules(presentationModule, domainModule, featureTemplatesModule, featureEditorModule)
        }

    }
}