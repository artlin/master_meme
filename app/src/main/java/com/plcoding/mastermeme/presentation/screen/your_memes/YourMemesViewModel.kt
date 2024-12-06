package com.plcoding.mastermeme.presentation.screen.your_memes

import androidx.lifecycle.viewModelScope
import com.plcoding.mastermeme.domain.MemeData
import com.plcoding.mastermeme.presentation.base.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
