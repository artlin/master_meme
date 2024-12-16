package com.plcoding.mastermeme.feature_editor.presentation

import androidx.compose.runtime.mutableStateOf
import com.plcoding.mastermeme.core.domain.model.EditionData
import com.plcoding.mastermeme.core.presentation.base.UIStateDelegate
import com.plcoding.mastermeme.feature_editor.domain.TextEntryFactory
import com.plcoding.mastermeme.feature_editor.domain.TextEntryMetaData

class AddTextControllerImpl(private val textEntryFactory: TextEntryFactory) : AddTextController {
    override var uiAddTextState: UIAddTextState by UIStateDelegate(
        mutableStateOf(provideDefaultState())
    )

    private var selectedTextEntry: TextEntryMetaData =
        textEntryFactory.createDefaultPlaceholderTextEntry(EditionData.getDefault())

    override fun addNewTextAtRandomPosition() {
        val textData = textEntryFactory.createNewTextAtRandomPosition(EditionData.getDefault())
            .updateTextStyleUsingEditionData(EditionData.getDefault())
        deselectAllTextElements()
        newState = uiAddTextState.addNewText(textData)
    }

    override fun handleTextClicked(textData: TextEntryMetaData) {
        if (isInteractionBlocked(textData)) return
        deselectAllTextElements()
        selectedTextEntry = textData.setFocused()
        newState = uiAddTextState.updateSelectedElement(selectedTextEntry)
    }

    override fun handleTextDoubleClicked(textData: TextEntryMetaData) {
        if (isInteractionBlocked(textData)) return
        selectedTextEntry = textData.setEditing()
        newState = uiAddTextState.updateSelectedElement(selectedTextEntry)
    }

    override fun handleDragEnd(
        textData: TextEntryMetaData,
        newPosX: Float,
        newPosY: Float
    ) {
        selectedTextEntry = textData.updatePosition(newPosX, newPosY)
        newState = uiAddTextState.updateSelectedElement(textData)
    }

    override fun updateStyleOfSelectedText(editionData: EditionData) {
        selectedTextEntry =
            selectedTextEntry.updateTextStyleUsingEditionData(editionData)
        newState = uiAddTextState.updateSelectedElement(selectedTextEntry)
    }

    override fun resetSelectedTextToOriginal() {
        selectedTextEntry = selectedTextEntry.resetChanges()
        newState = uiAddTextState.updateSelectedElement(selectedTextEntry)
    }

    override fun saveEditValues(selectedTextEditData: EditionData) {
        // update selected text metaData with selectedTextEdit data
        selectedTextEntry = selectedTextEntry.saveEditionData(selectedTextEditData)
        newState = uiAddTextState.updateSelectedElement(selectedTextEntry)
    }

    override fun deselectAllTextElements() {
        selectedTextEntry = selectedTextEntry.setNormal()
        newState = uiAddTextState.deselectAll().updateSelectedElement(selectedTextEntry)
    }

    var newState: UIAddTextState? = null
        set(value) {
            uiAddTextState = value ?: return
        }

    override fun isInteractionBlocked(textData: TextEntryMetaData): Boolean {
        if (textData.uid != selectedTextEntry.uid) return true
        return selectedTextEntry.visualState is TextEntryVisualState.Editing
    }

    companion object {
        fun provideDefaultState(): UIAddTextState {
            return UIAddTextState(
                textEntries = mutableMapOf()
            )
        }
    }

}