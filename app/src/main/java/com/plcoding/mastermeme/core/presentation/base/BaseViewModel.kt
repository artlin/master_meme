package com.plcoding.mastermeme.core.presentation.base

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.plcoding.mastermeme.core.presentation.navigation.NavigationController
import com.plcoding.mastermeme.core.presentation.navigation.route.NavigationRoute
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class BaseViewModel<UIState, UIEvent> :
    ViewModel(),
    KoinComponent,
    ViewModelInterface<UIState, UIEvent> {

    private val navController: NavigationController by inject()


    abstract fun getDefaultState(): UIState

    /**
     * delegation for uiState,
     * so we don't need to do uiState.value = value, just uiState = value
     */
    override var uiState: UIState by UIStateDelegate(mutableStateOf(getDefaultState()))


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

    fun navigateTo(navRoute: NavigationRoute) = navController.navigateTo(navRoute)
}
