package com.plcoding.mastermeme.feature_editor.presentation

import com.plcoding.mastermeme.core.domain.model.EditionData

interface EditTextController {
    val uiEditTextState: UIEditTextState

    fun styleOption()
    fun sizeOption()
    fun pickerOption()
    fun handleSizeChanged(value: Float)
    fun setEditionData(editionData: EditionData)
    fun getEditionData(): EditionData
}