package com.plcoding.mastermeme.core.presentation.screen.editor

sealed interface UIMemeEditorEvent {
    data object OnBackButtonClicked : UIMemeEditorEvent
    data object OnDialogConfirmDiscardClicked : UIMemeEditorEvent
    data object OnDialogConfirmCancelClicked : UIMemeEditorEvent
    data object OnEditCancelClicked : UIMemeEditorEvent
    data object OnEditConfirmClicked : UIMemeEditorEvent
}

typealias OnUIMemeEditorEvent = (UIMemeEditorEvent) -> Unit