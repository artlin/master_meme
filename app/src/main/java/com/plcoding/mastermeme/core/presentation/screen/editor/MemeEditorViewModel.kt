package com.plcoding.mastermeme.core.presentation.screen.editor

import androidx.navigation.NavBackStackEntry
import androidx.navigation.toRoute
import com.plcoding.mastermeme.core.presentation.base.BaseViewModel
import com.plcoding.mastermeme.core.presentation.navigation.route.NavigationRoute

class MemeEditorViewModel : BaseViewModel<UIMemeEditorState, UIMemeEditorEvent>() {

    override fun onEvent(event: UIMemeEditorEvent) {

    }

    override fun getDefaultUIState(): UIMemeEditorState {
        return UIMemeEditorState("")
    }

    override fun handleNavigation(backStackEntry: NavBackStackEntry) {
        val navParams = backStackEntry.toRoute<NavigationRoute.MemeEditor>().memeEditorParams
        val memeId = navParams.memeId
        memeId
    }
}
