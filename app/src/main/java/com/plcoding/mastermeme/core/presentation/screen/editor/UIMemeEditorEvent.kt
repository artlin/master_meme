package com.plcoding.mastermeme.core.presentation.screen.editor

sealed interface UIMemeEditorEvent {
    data object OnBackButtonClicked : UIMemeEditorEvent
}

typealias OnUIMemeEditorEvent = (UIMemeEditorEvent) -> Unit