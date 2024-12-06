package com.plcoding.mastermeme.core.presentation.screen.your_memes

import com.plcoding.mastermeme.core.domain.MemeData
import com.plcoding.mastermeme.core.presentation.base.BaseViewModel

class YourMemesViewModel : BaseViewModel<UIStateYourMemes, UIEventYourMemes>(getDefaultState()) {

    override fun onEvent(event: UIEventYourMemes) {
        when (event) {
            UIEventYourMemes.OnClick -> {
                // fixme : showcase test only
                newState = uiState.copy(memeList = listOf(MemeData()))
            }
        }
    }

    companion object {
        fun getDefaultState(): UIStateYourMemes {
            return UIStateYourMemes(emptyList())
        }
    }
}
