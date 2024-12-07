package com.plcoding.mastermeme.core.presentation.screen.your_memes

import com.plcoding.mastermeme.core.domain.factory.MemeDataFactory
import com.plcoding.mastermeme.core.presentation.base.BaseViewModel
import com.plcoding.mastermeme.core.presentation.navigation.route.MemeEditorParams
import com.plcoding.mastermeme.core.presentation.navigation.route.NavigationRoute

class YourMemesViewModel(private val memeDataFactory: MemeDataFactory) :
    BaseViewModel<UIStateYourMemes, UIEventYourMemes>() {

    override fun onEvent(event: UIEventYourMemes) {
        when (event) {
            UIEventYourMemes.OnClick -> {
                // fixme : showcase test only
                if (uiState.memeList.size == 1) {
                    navigateTo(NavigationRoute.MemeEditor(MemeEditorParams(666)))
                }
                newState = uiState.copy(memeList = listOf(memeDataFactory.getFakeMemeData()))
            }
        }
    }

    override fun getDefaultUIState(): UIStateYourMemes {
        return UIStateYourMemes(emptyList())
    }
}
