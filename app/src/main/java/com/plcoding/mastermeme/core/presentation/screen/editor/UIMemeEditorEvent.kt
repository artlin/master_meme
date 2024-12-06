package com.plcoding.mastermeme.core.presentation.screen.editor

sealed interface UIMemeEditorEvent {

}

typealias OnUIMemeEditorEvent = (UIMemeEditorEvent) -> Unit