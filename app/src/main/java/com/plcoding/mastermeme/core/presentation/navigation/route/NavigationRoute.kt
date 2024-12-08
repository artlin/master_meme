package com.plcoding.mastermeme.core.presentation.navigation.route

import com.plcoding.mastermeme.feature_templates.domain.TemplateData
import kotlinx.serialization.Serializable

@Serializable
sealed interface NavigationRoute {
    @Serializable
    data object YourMemes : NavigationRoute

    @Serializable
    data class MemeEditor(val memeEditorParams: MemeEditorParams = MemeEditorParams()) :
        NavigationRoute
}

@Serializable
data class MemeEditorParams(val template: TemplateData? = null)
