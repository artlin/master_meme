package com.plcoding.mastermeme.core.presentation.screen.editor

import com.plcoding.mastermeme.core.presentation.base.BaseViewModel
import com.plcoding.mastermeme.core.presentation.navigation.route.NavigationRoute
import com.plcoding.mastermeme.feature_templates.data.TemplatesProvider
import org.koin.core.component.KoinComponent

class MemeEditorViewModel(private val templatesProvider: TemplatesProvider) :
    BaseViewModel<UIMemeEditorState, UIMemeEditorEvent>(), KoinComponent {


    override fun onEvent(event: UIMemeEditorEvent) {

    }

    override fun getDefaultUIState(): UIMemeEditorState {
        return UIMemeEditorState(tempTemplate = null)
    }

    override fun handleNavigation() {
        getParams<NavigationRoute.MemeEditor> { navParams ->
            val params = navParams.memeEditorParams
            newState = uiState.copy(tempTemplate = params.template)
        }
    }
}
