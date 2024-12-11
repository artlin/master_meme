package com.plcoding.mastermeme.feature_editor.di

import com.plcoding.mastermeme.feature_editor.domain.TextEntryFactory
import com.plcoding.mastermeme.feature_editor.domain.TextEntryFactoryImpl
import com.plcoding.mastermeme.feature_editor.presentation.AddTextController
import com.plcoding.mastermeme.feature_editor.presentation.AddTextControllerImpl
import com.plcoding.mastermeme.feature_editor.presentation.EditTextController
import com.plcoding.mastermeme.feature_editor.presentation.EditTextControllerImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val featureEditorModule = module {
    singleOf(::AddTextControllerImpl) { bind<AddTextController>() }
    singleOf(::EditTextControllerImpl) { bind<EditTextController>() }
    singleOf(::TextEntryFactoryImpl) { bind<TextEntryFactory>() }
}