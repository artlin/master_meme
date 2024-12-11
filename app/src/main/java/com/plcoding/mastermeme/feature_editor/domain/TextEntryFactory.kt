package com.plcoding.mastermeme.feature_editor.domain

import androidx.compose.ui.text.font.FontStyle
import com.plcoding.mastermeme.feature_editor.presentation.TextEntryVisualState
import java.util.UUID
import kotlin.random.Random

interface TextEntryFactory {
    fun createDefaultTextAtRandomPosition(): TextEntryMetaData {
        return TextEntryMetaData(
            uid = UUID.randomUUID().toString(),
            posX = Random.nextFloat().coerceIn(0f, 1f),
            posY = Random.nextFloat().coerceIn(0f, 1f),
            currentText = "${counter++} Tap twice to edit".uppercase(),
            editedText = "",
            fontStyle = FontStyle.Normal,
            visualState = TextEntryVisualState.Normal
        )
    }
    companion object{
        var counter = 0
    }
}