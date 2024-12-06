package com.plcoding.mastermeme.core.presentation.screen.your_memes

sealed interface UIEventYourMemes {
    object OnClick : UIEventYourMemes
}

typealias OnUIEventYourMemes = (UIEventYourMemes) -> Unit
