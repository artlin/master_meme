package com.plcoding.mastermeme.feature_templates.di

import com.plcoding.mastermeme.feature_templates.data.TemplatesProvider
import com.plcoding.mastermeme.feature_templates.data.TemplatesProviderImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val featureTemplatesModule = module {
    singleOf(::TemplatesProviderImpl) { bind<TemplatesProvider>() }
}