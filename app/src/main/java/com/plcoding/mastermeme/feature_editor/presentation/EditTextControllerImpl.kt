package com.plcoding.mastermeme.feature_editor.presentation

import androidx.compose.runtime.mutableStateOf
import com.plcoding.mastermeme.core.domain.model.EditionData
import com.plcoding.mastermeme.core.presentation.base.UIStateDelegate

class EditTextControllerImpl : EditTextController {
    override var uiEditTextState: UIEditTextState by UIStateDelegate(
        mutableStateOf(provideDefaultState())
    )

    private var editionData: EditionData = EditionData.getDefault()

    override fun updateEditionDataWithFontProgress(value: Float) {
        newState = uiEditTextState.updateTextSize { state ->
            state.updateProgress(newProgress = value)
        }
    }

    override fun getEditionData(): EditionData {
        updateEditionData()
        return editionData
    }

    override fun cancelEditState() {
        newState = provideDefaultState()
        editionData = EditionData.getDefault()
    }

    override fun getCurrentEditData(): EditionData {
        return editionData
    }

    override fun applyEditionData(editionData: EditionData) {
        this.editionData = editionData
        newState = uiEditTextState.updateTextSize { state ->
            state.copy(uiProgress = editionData.getFontScale())
        }
    }

    private fun updateEditionData() {
        editionData = editionData.setFontScale(uiEditTextState.textSizeState.uiProgress)
    }

    override fun setEditionData(editionData: EditionData) {
        this.editionData = editionData
    }


    override fun styleOption() {
        newState = uiEditTextState.openStylePanel()
    }

    override fun sizeOption() {
        newState = uiEditTextState.openSizePanel()
    }

    override fun pickerOption() {
        newState = uiEditTextState.openColorPickerPanel()
    }


    companion object {
        fun provideDefaultState(): UIEditTextState {
            return UIEditTextState(
                currentOption = SelectedEditOption.None
            )
        }
    }

    var newState: UIEditTextState? = null
        set(value) {
            uiEditTextState = value ?: return
        }
}
