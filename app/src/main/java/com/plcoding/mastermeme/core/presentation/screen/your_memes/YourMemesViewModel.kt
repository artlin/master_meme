package com.plcoding.mastermeme.core.presentation.screen.your_memes

import com.plcoding.mastermeme.core.domain.factory.MemeDataFactory
import com.plcoding.mastermeme.core.presentation.base.BaseViewModel
import com.plcoding.mastermeme.core.presentation.navigation.route.MemeEditorParams
import com.plcoding.mastermeme.core.presentation.navigation.route.NavigationRoute
import com.plcoding.mastermeme.feature_templates.data.TemplatesProvider
import com.plcoding.mastermeme.feature_templates.presentation.BottomSheetState
import com.plcoding.mastermeme.feature_templates.presentation.BottomSheetVisibility

class YourMemesViewModel(
    private val memeDataFactory: MemeDataFactory, private val templatesProvider: TemplatesProvider
) : BaseViewModel<UIStateYourMemes, UIEventYourMemes>() {

    override fun onEvent(event: UIEventYourMemes) {
        when (event) {
            UIEventYourMemes.OnClick -> {
                // fixme : showcase test only
                if (uiState.memeList.size == 1) {
                    newState = uiState.updateBottomSheetState { state ->
                        state.open(templateList = templatesProvider.getAllTemplates())
                    }
                }
                // fixme : showcase test only
                newState = uiState.copy(memeList = listOf(memeDataFactory.getFakeMemeData()))
            }

            is UIEventYourMemes.OnUserChangedSheetState -> {
                val requestedVisibility = event.requestedVisibility
                if (uiState.bottomSheetState.visibility != requestedVisibility) {
                    newState = uiState.updateBottomSheetState { state ->
                        state.setVisibility(visibility = requestedVisibility)
                    }
                }
            }

            is UIEventYourMemes.OnTemplateClick -> {
                newState = uiState.updateBottomSheetState { state ->
                    state.close()
                }
                navigateTo(NavigationRoute.MemeEditor(MemeEditorParams(template = event.template)))
            }
        }
    }

    override fun getDefaultUIState(): UIStateYourMemes {
        return UIStateYourMemes(
            memeList = emptyList(), bottomSheetState = BottomSheetState(
                visibility = BottomSheetVisibility.Hidden,
                templateList = emptyList(),
            )
        )
    }
}
