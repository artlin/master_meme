package com.plcoding.mastermeme.core.di

import com.plcoding.mastermeme.core.presentation.navigation.NavigationController
import com.plcoding.mastermeme.core.presentation.navigation.NavigationControllerImpl
import com.plcoding.mastermeme.core.presentation.screen.editor.MemeEditorViewModel
import com.plcoding.mastermeme.core.presentation.screen.your_memes.YourMemesViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::YourMemesViewModel)
    viewModelOf(::MemeEditorViewModel)
    singleOf(::NavigationControllerImpl) { bind<NavigationController>() }
}