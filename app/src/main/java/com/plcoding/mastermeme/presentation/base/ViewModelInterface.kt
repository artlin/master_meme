package com.plcoding.mastermeme.presentation.base

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

interface ViewModelInterface<UIState, UIEvent> {

    val uiState: UIState

    fun onEvent(event: UIEvent)

}