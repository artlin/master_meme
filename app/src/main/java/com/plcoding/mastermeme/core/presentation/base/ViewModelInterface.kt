package com.plcoding.mastermeme.core.presentation.base

interface ViewModelInterface<UIState, UIEvent> {

    val uiState: UIState

    fun onEvent(event: UIEvent)

}