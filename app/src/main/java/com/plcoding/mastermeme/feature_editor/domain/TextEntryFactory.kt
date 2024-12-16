package com.plcoding.mastermeme.feature_editor.domain

import androidx.compose.ui.text.TextStyle
import com.plcoding.mastermeme.core.domain.model.EditionData
import com.plcoding.mastermeme.feature_editor.presentation.TextEntryVisualState
import java.util.UUID
import kotlin.random.Random

interface TextEntryFactory {
    fun createNewTextAtRandomPosition(editionData: EditionData): TextEntryMetaData {
        return TextEntryMetaData(
            uid = UUID.randomUUID().toString(),
            posX = Random.nextFloat().coerceIn(0f, 1f),
            posY = Random.nextFloat().coerceIn(0f, 1f),
            originalText = "${counter++} Tap twice to edit".uppercase(),
            editedText = "",
            originalStyle = TextStyle.Default,
            editingStyle = TextStyle.Default,
            editionData = editionData,
            visualState = TextEntryVisualState.Normal
        )
    }

    fun createDefaultPlaceholderTextEntry(editionData: EditionData): TextEntryMetaData {
        return TextEntryMetaData(
            uid = "",
            posX = 0f,
            posY = 0f,
            originalText = "",
            editedText = "",
            originalStyle = TextStyle.Default,
            editingStyle = TextStyle.Default,
            editionData = editionData,
            visualState = TextEntryVisualState.Normal
        )
    }

    companion object {
        var counter = 0
    }
}