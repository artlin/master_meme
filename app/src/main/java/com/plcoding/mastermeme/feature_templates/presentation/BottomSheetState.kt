package com.plcoding.mastermeme.feature_templates.presentation

import com.plcoding.mastermeme.feature_templates.domain.TemplateData

data class BottomSheetState(
    val visibility: BottomSheetVisibility,
    val templateList: List<TemplateData>
) {
    fun isVisible(): Boolean = visibility != BottomSheetVisibility.Hidden
    fun open(templateList: List<TemplateData>): BottomSheetState = copy(
        visibility = BottomSheetVisibility.HalfExpanded,
        templateList = templateList
    )

    fun close(): BottomSheetState = copy(
        visibility = BottomSheetVisibility.Hidden,
    )

    fun setVisibility(visibility: BottomSheetVisibility): BottomSheetState =
        copy(visibility = visibility)
}

sealed interface BottomSheetVisibility {
    data object HalfExpanded : BottomSheetVisibility
    data object FullyExpanded : BottomSheetVisibility
    data object Hidden : BottomSheetVisibility
}
