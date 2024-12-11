package com.plcoding.mastermeme.core.presentation.screen.editor

import com.plcoding.mastermeme.feature_editor.domain.TextEntryMetaData

sealed interface UIAddTextPanelEvent : UIMemeEditorEvent {
    data object AddTextClicked : UIAddTextPanelEvent
    data object SaveMemeClicked : UIAddTextPanelEvent
    data object UndoButtonClicked : UIAddTextPanelEvent
    data object RedoButtonClicked : UIAddTextPanelEvent
    data class OnTextClicked(val textEntryMetaData: TextEntryMetaData) : UIAddTextPanelEvent
    data class OnTextDoubleClicked(val textEntryMetaData: TextEntryMetaData) : UIAddTextPanelEvent
    data class OnDragEnd(
        val newPosX: Float,
        val newPosY: Float,
        val textEntryMetaData: TextEntryMetaData
    ) : UIAddTextPanelEvent
}
typealias OnAddTextPanelEvent = (UIAddTextPanelEvent) -> Unit