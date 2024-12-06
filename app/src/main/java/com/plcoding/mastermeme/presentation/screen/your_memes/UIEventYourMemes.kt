package com.plcoding.mastermeme.presentation.screen.your_memes

sealed interface UIEventYourMemes {
    object OnClick : UIEventYourMemes
}

typealias OnUIEventYourMemes = (UIEventYourMemes) -> Unit
