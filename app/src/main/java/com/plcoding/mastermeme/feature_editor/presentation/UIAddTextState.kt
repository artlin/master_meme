package com.plcoding.mastermeme.feature_editor.presentation

import com.plcoding.mastermeme.feature_editor.domain.TextEntryMetaData

data class UIAddTextState(
    val textEntries: MutableMap<String, TextEntryMetaData>
) {

    fun addNewText(newText: TextEntryMetaData): UIAddTextState {
        val newMap = textEntries.toMutableMap()
        newMap[newText.uid] = newText.copy()
        return copy(textEntries = newMap)
    }

    fun updateSelectedElement(newTextEntry: TextEntryMetaData): UIAddTextState {
        // Find the exact instance from the textEntries Set
//        val existingInstance = textEntries.find { it.uid == newTextEntry.uid } ?: return this
        // Create new instance with updated state
        // Create new Set by removing old and adding new instance
//        val updatedEntries = textEntries - existingInstance + newTextEntry
//        val updatedEntries = textEntries[] newTextEntry
        val newMap = textEntries.toMutableMap()
        newMap[newTextEntry.uid] = newTextEntry.copy()
        return copy(
            textEntries = newMap,
        )
    }

    fun deselectAll(): UIAddTextState {
        return copy(textEntries = textEntries.mapValues { it.value.setNormal() }.toMutableMap())
    }
}

sealed interface TextEntryVisualState {
    data object Normal : TextEntryVisualState
    data object Focused : TextEntryVisualState
    data object Editing : TextEntryVisualState
}