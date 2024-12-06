package com.plcoding.mastermeme.core.presentation.navigation.route

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
data class MemeEditorParams(val memeId: Int? = null)
