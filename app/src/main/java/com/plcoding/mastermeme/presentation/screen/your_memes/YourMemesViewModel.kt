package com.plcoding.mastermeme.presentation.screen.your_memes

import com.plcoding.mastermeme.presentation.base.BaseViewModel

class YourMemesViewModel : BaseViewModel<UIStateYourMemes, UIEventYourMemes>(getDefaultState()) {

    override fun onEvent(event: UIEventYourMemes) {

    }

    companion object {
        fun getDefaultState(): UIStateYourMemes {
            return UIStateYourMemes(emptyList())
        }
    }
}
