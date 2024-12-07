package com.plcoding.mastermeme.core.presentation.base

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.plcoding.mastermeme.core.presentation.navigation.NavigationController
import com.plcoding.mastermeme.core.presentation.navigation.route.NavigationRoute
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

abstract class BaseViewModel<UIState, UIEvent> :
    ViewModel(),
    KoinComponent,
    ViewModelInterface<UIState, UIEvent> {

    val navController: NavigationController by inject()

    init {
        handleNavigation()
    }

    abstract fun getDefaultUIState(): UIState

    /**
     * delegation for uiState,
     * so we don't need to do uiState.value = value, just uiState = value
     */
    override var uiState: UIState by UIStateDelegate(mutableStateOf(getDefaultUIState()))


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


    private fun handleNavParams() {


    }

    protected open fun handleNavigation() {

    }

    protected inline fun <reified T> getParams(callback: (para: T) -> Unit) {
        val backStackEntry =
            navController.getCurrentNavController()?.currentBackStackEntry ?: return
        callback(backStackEntry.toRoute<T>())

    }

    protected fun navigateTo(navRoute: NavigationRoute) = navController.navigateTo(navRoute)


//
//    with(navigationController) {
//        viewModelScope.watchStateHandle<String>(
//            key = SELECTED_RINGTONE_KEY,
//            defaultValue = null
//        ) { ringtoneUri ->
//            ringtoneUri?.let {
//                val selectedRingtone = ringtonesManager.getRingtoneByUri(ringtoneUri)
//                newState = uiState.value.copy(
//                    selectedRingtoneEntity = selectedRingtone
//                )
//            }
//            validateUi()
//        }
//    }

}
