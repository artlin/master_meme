package com.plcoding.mastermeme.feature_editor.presentation

import com.plcoding.mastermeme.feature_editor.presentation.SelectedEditOption.OptionPicker
import com.plcoding.mastermeme.feature_editor.presentation.SelectedEditOption.OptionSize
import com.plcoding.mastermeme.feature_editor.presentation.SelectedEditOption.OptionStyle

data class UIEditTextState(
    val currentOption: SelectedEditOption,
    val textSize: TextSize = TextSize.provideDefaultState()
) {
    fun openSizePanel(): UIEditTextState = copy(currentOption = OptionSize)
    fun openStylePanel(): UIEditTextState = copy(currentOption = OptionStyle)
    fun openColorPickerPanel(): UIEditTextState = copy(currentOption = OptionPicker)

    fun updateTextSize(predicate: (TextSize) -> TextSize): UIEditTextState {
        return copy(textSize = predicate(textSize))
    }

    companion object {
        fun provideDefaultSizeState(): TextSize = TextSize.provideDefaultState()
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


data class TextSize(val size: Int, val uiProgress: Float) {

    fun updateProgress(newProgress: Float): TextSize {
        return copy(uiProgress = newProgress)
    }

    companion object {
        fun provideDefaultState(): TextSize {
            return TextSize(1, .5f)
        }
    }
}