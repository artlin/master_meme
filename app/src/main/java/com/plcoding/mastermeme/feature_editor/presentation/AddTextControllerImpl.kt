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
        textEntryFactory.createDefaultPlaceholderTextEntry()

    override fun addNewText() {
        val textData = textEntryFactory.createNewTextAtRandomPosition()
            .updateTextStyleUsingEditionData(EditionData.getDefault())
        deselectAll()
        newState = uiAddTextState.addNewText(textData)
    }

    override fun handleTextClicked(textData: TextEntryMetaData) {
        if (isEditInProgress()) return
        deselectAll()
        selectedTextEntry = textData.setFocused()
        newState = uiAddTextState.updateSelectedText(selectedTextEntry)
    }

    override fun handleTextDoubleClicked(textData: TextEntryMetaData) {
        if (isEditInProgress()) return
        selectedTextEntry = textData.setEditing()
        newState = uiAddTextState.updateSelectedText(selectedTextEntry)
    }

    override fun handleDragEnd(
        textData: TextEntryMetaData,
        newPosX: Float,
        newPosY: Float
    ) {
        selectedTextEntry = textData.updatePosition(newPosX, newPosY)
        newState = uiAddTextState.updateSelectedText(textData)
    }

    override fun updateStyleOfSelectedText(editionData: EditionData) {
        selectedTextEntry =
            selectedTextEntry.updateTextStyleUsingEditionData(editionData)
        newState = uiAddTextState.updateSelectedText(selectedTextEntry)
    }

    override fun deselectAll() {
        newState = uiAddTextState.deselectAll()
    }

    var newState: UIAddTextState? = null
        set(value) {
            uiAddTextState = value ?: return
        }

    private fun isEditInProgress(): Boolean {
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