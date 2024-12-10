package com.plcoding.mastermeme.core.presentation.screen.editor

sealed interface AddTextPanelEvent : UIMemeEditorEvent {
    data object AddAddTextClicked : AddTextPanelEvent
    data object SaveMemeClicked : AddTextPanelEvent
    data object UndoButtonClicked : AddTextPanelEvent
    data object RedoButtonClicked : AddTextPanelEvent
}