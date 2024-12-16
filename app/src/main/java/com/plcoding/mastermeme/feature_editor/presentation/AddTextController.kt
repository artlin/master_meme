package com.plcoding.mastermeme.feature_editor.presentation

import com.plcoding.mastermeme.core.domain.model.EditionData
import com.plcoding.mastermeme.feature_editor.domain.TextEntryMetaData

interface AddTextController {
    val uiAddTextState: UIAddTextState

    fun isInteractionBlocked(textData: TextEntryMetaData): Boolean
    fun addNewTextAtRandomPosition()
    fun deselectAllTextElements()
    fun handleTextClicked(textData: TextEntryMetaData)
    fun handleTextDoubleClicked(textData: TextEntryMetaData)
    fun handleDragEnd(textData: TextEntryMetaData, newPosX: Float, newPosY: Float)
    fun updateStyleOfSelectedText(editionData: EditionData)
    fun resetSelectedTextToOriginal()
    fun saveEditValues(selectedTextEditData: EditionData)
}