package com.plcoding.mastermeme.feature_editor.domain

import androidx.compose.ui.text.TextStyle
import com.plcoding.mastermeme.feature_editor.presentation.TextEntryVisualState
import java.util.UUID
import kotlin.random.Random

interface TextEntryFactory {
    fun createNewTextAtRandomPosition(): TextEntryMetaData {
        return TextEntryMetaData(
            uid = UUID.randomUUID().toString(),
            posX = Random.nextFloat().coerceIn(0f, 1f),
            posY = Random.nextFloat().coerceIn(0f, 1f),
            currentText = "${counter++} Tap twice to edit".uppercase(),
            editedText = "",
            textStyle = TextStyle.Default,
            editingStyle = TextStyle.Default,
            visualState = TextEntryVisualState.Normal
        )
    }

    fun createDefaultPlaceholderTextEntry(): TextEntryMetaData {
        return TextEntryMetaData(
            uid = "",
            posX = 0f,
            posY = 0f,
            currentText = "",
            editedText = "",
            textStyle = TextStyle.Default,
            editingStyle = TextStyle.Default,
            visualState = TextEntryVisualState.Normal
        )
    }

    companion object {
        var counter = 0
    }
}