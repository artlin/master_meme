package com.plcoding.mastermeme.core.presentation.screen.editor

sealed interface UIEditTextPanelEvent : UIMemeEditorEvent {
    data object OnStyleOptionClicked : UIEditTextPanelEvent
    data object OnSizeOptionClicked : UIEditTextPanelEvent
    data object OnPickerOptionClicked : UIEditTextPanelEvent

    data class FonSizeChanged(val value: Float) : UIEditTextPanelEvent
}

typealias OnUIEditTextPanelEvent = (UIEditTextPanelEvent) -> Unit