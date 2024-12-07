package com.plcoding.mastermeme.core.presentation.screen.editor

import com.plcoding.mastermeme.core.presentation.base.BaseViewModel
import com.plcoding.mastermeme.core.presentation.navigation.route.NavigationRoute

class MemeEditorViewModel : BaseViewModel<UIMemeEditorState, UIMemeEditorEvent>() {


    override fun onEvent(event: UIMemeEditorEvent) {

    }

    override fun getDefaultUIState(): UIMemeEditorState {
        return UIMemeEditorState("")
    }

    override fun handleNavigation() {
        getParams<NavigationRoute.MemeEditor> { navParams ->
            val memeId = navParams.memeEditorParams
            memeId
        }
    }
}
