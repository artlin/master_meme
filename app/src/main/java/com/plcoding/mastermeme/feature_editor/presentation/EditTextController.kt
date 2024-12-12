package com.plcoding.mastermeme.feature_editor.presentation

import androidx.compose.ui.text.font.FontStyle

interface EditTextController {
    val uiEditTextState: UIEditTextState

    fun styleOption()
    fun sizeOption()
    fun pickerOption()
    fun handleSizeChanged(value: Float)
    fun getEditedStyleResult(): FontStyle
}