package com.plcoding.mastermeme.feature_editor.presentation

import androidx.compose.ui.text.font.FontStyle

data class UIAddTextState(val textEntries: Set<TextEntryMetaData>) {
    fun randomText(): UIAddTextState {
        return copy(
            textEntries = setOf(
                TextEntryMetaData(
                    uid = "",
                    posX = 0f,
                    posY = 0f,
                    currentText = "My Text",
                    editedText = "",
                    textStyle = FontStyle.Normal,
                    visualState = TextEntryVisualState.Normal
                )
            )
        )
    }
}

data class TextEntryMetaData(
    val uid: String,
    val posX: Float,
    val posY: Float,
    val currentText: String,
    val editedText: String,
    val textStyle: FontStyle,
    val visualState: TextEntryVisualState
)

sealed interface TextEntryVisualState {
    data object Normal : TextEntryVisualState
    data object Focused : TextEntryVisualState
    data object Editing : TextEntryVisualState
}