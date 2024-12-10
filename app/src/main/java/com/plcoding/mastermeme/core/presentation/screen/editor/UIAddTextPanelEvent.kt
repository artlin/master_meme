package com.plcoding.mastermeme.core.presentation.screen.editor

import com.plcoding.mastermeme.feature_editor.presentation.TextEntryMetaData

sealed interface UIAddTextPanelEvent : UIMemeEditorEvent {
    data object AddUIAddTextClicked : UIAddTextPanelEvent
    data object SaveMemeClicked : UIAddTextPanelEvent
    data object UndoButtonClicked : UIAddTextPanelEvent
    data object RedoButtonClicked : UIAddTextPanelEvent
    data class OnTextClicked(val textEntryMetaData: TextEntryMetaData) : UIAddTextPanelEvent
    data object OnTextDoubleClicked : UIAddTextPanelEvent
}
typealias OnAddTextPanelEvent = (UIAddTextPanelEvent) -> Unit