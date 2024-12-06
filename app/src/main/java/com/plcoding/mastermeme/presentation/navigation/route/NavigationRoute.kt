package com.plcoding.mastermeme.presentation.navigation.route

import kotlinx.serialization.Serializable

@Serializable
sealed interface NavigationRoute {
    @Serializable
    data object YourMemes : NavigationRoute
}
