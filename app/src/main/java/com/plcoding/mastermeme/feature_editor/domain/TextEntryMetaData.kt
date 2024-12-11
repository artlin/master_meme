package com.plcoding.mastermeme.feature_editor.domain

import androidx.compose.ui.text.font.FontStyle
import com.plcoding.mastermeme.feature_editor.presentation.TextEntryVisualState

data class TextEntryMetaData(
    val uid: String,
    val posX: Float,
    val posY: Float,
    val currentText: String,
    val editedText: String,
    val fontStyle: FontStyle,
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
}