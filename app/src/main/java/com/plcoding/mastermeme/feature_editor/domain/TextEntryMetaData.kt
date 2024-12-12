package com.plcoding.mastermeme.feature_editor.domain

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import com.plcoding.mastermeme.core.domain.model.EditionData
import com.plcoding.mastermeme.feature_editor.presentation.TextEntryVisualState

data class TextEntryMetaData(
    val uid: String,
    val posX: Float,
    val posY: Float,
    val currentText: String,
    val editedText: String,
    val textStyle: TextStyle,
    val editingStyle: TextStyle,
    val visualState: TextEntryVisualState
) {
    fun setFocused(): TextEntryMetaData {
        return copy(visualState = TextEntryVisualState.Focused)
    }

    fun setEditing(): TextEntryMetaData {
        return copy(visualState = TextEntryVisualState.Editing)
    }

    fun setNormal(): TextEntryMetaData {
        return copy(visualState = TextEntryVisualState.Normal)
    }

    fun updatePosition(newPosX: Float, newPosY: Float): TextEntryMetaData {
        return copy(posX = newPosX, posY = newPosY)
    }

    fun updateTextStyleUsingEditionData(editionData: EditionData): TextEntryMetaData {
        println("Current font size : ${editionData.getFontSize()}")
        return updateTextStyle { style ->
            style.copy(fontSize = TextUnit(editionData.getFontSize(), TextUnitType.Sp))
        }
    }

    private fun updateTextStyle(predicate: (textStyle: TextStyle) -> TextStyle): TextEntryMetaData {
        return copy(editingStyle = predicate(textStyle))
    }
}