package com.plcoding.mastermeme.feature_editor.presentation

data class UIEditTextState(val currentOption: SelectedEditOption) {
    fun openSizePanel(): UIEditTextState = copy(currentOption = SelectedEditOption.TextSize(1))
    fun openStylePanel(): UIEditTextState = copy(currentOption = SelectedEditOption.TextStyle(1))
    fun openColorPickerPanel(): UIEditTextState = copy(currentOption = SelectedEditOption.ColorPicker(1))
}


sealed interface SelectedEditOption {
    data class TextSize(val size: Int) : SelectedEditOption
    data class TextStyle(val size: Int) : SelectedEditOption
    data class ColorPicker(val size: Int) : SelectedEditOption
    data object None : SelectedEditOption
}