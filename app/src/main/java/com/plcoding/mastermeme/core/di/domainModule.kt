package com.plcoding.mastermeme.core.di

import com.plcoding.mastermeme.core.domain.factory.MemeDataFactory
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {
    singleOf(::MemeDataFactory)
}