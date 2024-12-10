package com.plcoding.mastermeme.feature_editor.presentation

import androidx.compose.runtime.mutableStateOf
import com.plcoding.mastermeme.core.presentation.base.UIStateDelegate

class AddTextControllerImpl : AddTextController {
    override var uiAddTextState: UIAddTextState by UIStateDelegate(mutableStateOf(UIAddTextState(
        emptySet()
    )))

    override fun addRandomText() {
        newState = uiAddTextState.randomText()
    }


    var newState: UIAddTextState? = null
        set(value) {
            uiAddTextState = value ?: return
        }

}