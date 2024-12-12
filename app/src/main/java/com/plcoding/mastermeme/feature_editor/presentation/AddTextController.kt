package com.plcoding.mastermeme.feature_editor.presentation

import androidx.compose.ui.text.font.FontStyle
import com.plcoding.mastermeme.feature_editor.domain.TextEntryMetaData

interface AddTextController {
    val uiAddTextState: UIAddTextState

    fun addNewText()
    fun deselectAll()
    fun handleTextClicked(textData: TextEntryMetaData)
    fun handleTextDoubleClicked(textData: TextEntryMetaData)
    fun handleDragEnd(textData: TextEntryMetaData, newPosX: Float, newPosY: Float)
    fun updateStyleOfSelectedText(editedStyleResult: FontStyle)
}