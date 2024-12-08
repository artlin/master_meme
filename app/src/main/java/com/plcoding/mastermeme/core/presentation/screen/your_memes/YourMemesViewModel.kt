package com.plcoding.mastermeme.core.presentation.screen.your_memes

import com.plcoding.mastermeme.core.domain.factory.MemeDataFactory
import com.plcoding.mastermeme.core.presentation.base.BaseViewModel
import com.plcoding.mastermeme.core.presentation.navigation.route.MemeEditorParams
import com.plcoding.mastermeme.core.presentation.navigation.route.NavigationRoute
import com.plcoding.mastermeme.feature_templates.data.TemplatesProvider
import com.plcoding.mastermeme.feature_templates.presentation.BottomSheetState
import com.plcoding.mastermeme.feature_templates.presentation.BottomSheetVisibility

class YourMemesViewModel(
    private val memeDataFactory: MemeDataFactory,
    private val templatesProvider: TemplatesProvider
) :
    BaseViewModel<UIStateYourMemes, UIEventYourMemes>() {

    override fun onEvent(event: UIEventYourMemes) {
        when (event) {
            UIEventYourMemes.OnClick -> {
                // fixme : showcase test only
                if (uiState.memeList.size == 1) {
                    newState = uiState.updateBottomSheetState {
                        it.open(templateList = templatesProvider.getAllTemplates())
                    }
                }
                newState = uiState.copy(memeList = listOf(memeDataFactory.getFakeMemeData()))
            }

            is UIEventYourMemes.OnUserChangedSheetState -> {
                val requestedState = event.requestedVisibility
                if (uiState.bottomSheetState.visibility != requestedState) {
                    newState = uiState.updateBottomSheetState {
                        it.copy(visibility = requestedState)
                    }
                }
            }

            is UIEventYourMemes.OnTemplateClick -> {
                newState = uiState.updateBottomSheetState {
                    it.close()
                }
                navigateTo(NavigationRoute.MemeEditor(MemeEditorParams(template = event.template)))
            }
        }
    }

    override fun getDefaultUIState(): UIStateYourMemes {
        return UIStateYourMemes(
            memeList = emptyList(),
            bottomSheetState = BottomSheetState(
                visibility = BottomSheetVisibility.Hidden,
                templateList = emptyList(),
            )
        )
    }
}
