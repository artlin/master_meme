package com.plcoding.mastermeme.feature_editor.di

import com.plcoding.mastermeme.feature_editor.presentation.AddTextController
import com.plcoding.mastermeme.feature_editor.presentation.AddTextControllerImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val featureEditorModule = module {
    singleOf(::AddTextControllerImpl) { bind<AddTextController>() }
}