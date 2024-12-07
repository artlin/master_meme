package com.plcoding.mastermeme.core.presentation.screen.your_memes

import com.plcoding.mastermeme.core.domain.model.MemeData
import com.plcoding.mastermeme.feature_templates.presentation.BottomSheetState


data class UIStateYourMemes(
    val memeList: List<MemeData>,
    val bottomSheetState: BottomSheetState
) {

    fun updateBottomSheetState(update: (BottomSheetState) -> BottomSheetState): UIStateYourMemes {
        return copy(bottomSheetState = update(bottomSheetState))
    }
}
