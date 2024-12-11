package com.plcoding.mastermeme.feature_editor.presentation

interface EditTextController {
    val uiEditTextState: UIEditTextState

    fun styleOption()
    fun sizeOption()
    fun pickerOption()
}