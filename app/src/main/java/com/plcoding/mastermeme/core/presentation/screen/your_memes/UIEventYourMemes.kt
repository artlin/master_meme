package com.plcoding.mastermeme.core.presentation.screen.your_memes

import com.plcoding.mastermeme.feature_templates.presentation.BottomSheetVisibility

sealed interface UIEventYourMemes {
    object OnClick : UIEventYourMemes
    data class OnUserChangedSheetState(val newSheetVisibility: BottomSheetVisibility) :
        UIEventYourMemes
}

typealias OnUIEventYourMemes = (UIEventYourMemes) -> Unit
