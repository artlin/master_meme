package com.plcoding.mastermeme.feature_editor.presentation

import com.plcoding.mastermeme.feature_editor.presentation.SelectedEditOption.OptionPicker
import com.plcoding.mastermeme.feature_editor.presentation.SelectedEditOption.OptionSize
import com.plcoding.mastermeme.feature_editor.presentation.SelectedEditOption.OptionStyle

data class UIEditTextState(
    val currentOption: SelectedEditOption,
    val textSizeState: TextSizeState = TextSizeState.provideDefaultState()
) {
    fun openSizePanel(): UIEditTextState = copy(currentOption = OptionSize)
    fun openStylePanel(): UIEditTextState = copy(currentOption = OptionStyle)
    fun openColorPickerPanel(): UIEditTextState = copy(currentOption = OptionPicker)

    fun updateTextSize(predicate: (TextSizeState) -> TextSizeState): UIEditTextState {
        return copy(textSizeState = predicate(textSizeState))
    }
}

sealed interface SelectedEditOption {
    data object OptionStyle : SelectedEditOption
    data object OptionSize : SelectedEditOption
    data object OptionPicker : SelectedEditOption
    data object None : SelectedEditOption
}


data class ColorPicker(val size: Int)

data class TextStyle(val size: Int)
