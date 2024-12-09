package com.plcoding.mastermeme.feature_editor.presentation

import androidx.compose.runtime.mutableStateOf
import com.plcoding.mastermeme.core.presentation.base.UIStateDelegate

class EditTextControllerImpl : EditTextController {
    override var uiEditTextState: UIEditTextState by UIStateDelegate(
        mutableStateOf(provideDefaultState())
    )

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
