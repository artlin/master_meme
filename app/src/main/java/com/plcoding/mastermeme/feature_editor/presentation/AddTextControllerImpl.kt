package com.plcoding.mastermeme.feature_editor.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.font.FontStyle
import com.plcoding.mastermeme.core.presentation.base.UIStateDelegate
import com.plcoding.mastermeme.feature_editor.domain.TextEntryFactory
import com.plcoding.mastermeme.feature_editor.domain.TextEntryMetaData

class AddTextControllerImpl(val textEntryFactory: TextEntryFactory) : AddTextController {
    override var uiAddTextState: UIAddTextState by UIStateDelegate(
        mutableStateOf(provideDefaultState())
    )

    private var selectedTextEntry: TextEntryMetaData = TextEntryMetaData(
        uid = "",
        posX = 0f,
        posY = 0f,
        currentText = "",
        editedText = "",
        fontStyle = FontStyle.Normal,
        visualState = TextEntryVisualState.Normal
    )

    override fun addNewText() {
        val textData = textEntryFactory.createDefaultTextAtRandomPosition()
        deselectAll()
        newState = uiAddTextState.addNewText(textData)
        selectedTextEntry = textData.setFocused()
        newState = uiAddTextState.updateSelectedText(selectedTextEntry)

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

    private fun deselectAll() {
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