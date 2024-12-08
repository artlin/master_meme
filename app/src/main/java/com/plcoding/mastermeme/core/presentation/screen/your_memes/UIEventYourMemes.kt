package com.plcoding.mastermeme.core.presentation.screen.your_memes

import com.plcoding.mastermeme.core.domain.value.ImageLocation
import com.plcoding.mastermeme.feature_templates.domain.TemplateData
import com.plcoding.mastermeme.feature_templates.presentation.BottomSheetVisibility

sealed interface UIEventYourMemes {
    object OnClick : UIEventYourMemes
    data class OnUserChangedSheetState(val requestedVisibility: BottomSheetVisibility) :
        UIEventYourMemes

    data class OnTemplateClick(val template: TemplateData) : UIEventYourMemes
}

typealias OnUIEventYourMemes = (UIEventYourMemes) -> Unit
