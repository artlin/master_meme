package com.plcoding.mastermeme.di

import com.plcoding.mastermeme.presentation.screen.your_memes.YourMemesViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::YourMemesViewModel)
}