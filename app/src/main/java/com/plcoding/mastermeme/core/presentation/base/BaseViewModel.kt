package com.plcoding.mastermeme.core.presentation.base

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<UIState, UIEvent>(uiState: UIState) :
    ViewModel(),
    ViewModelInterface<UIState, UIEvent> {

    /**
     * delegation for uiState,
     * so we don't need to do uiState.value = value, just uiState = value
     */
    override var uiState: UIState by UIStateDelegate(mutableStateOf(uiState))

    /**
     * shortcut for setting value to state
     * example :
     * newState = uiState.value.copy(...)
     * or
     * newState = uiState.copy(...) if delegation has been used
     */
    var newState: UIState = uiState
        set(value) {
            uiState = value
        }
}
