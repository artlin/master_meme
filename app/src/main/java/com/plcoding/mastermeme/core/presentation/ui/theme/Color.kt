package com.plcoding.mastermeme.core.presentation.ui.theme

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val White = Color(0xFFFFFFFF)
val Dark = Color(0xFF000000)

val DarkGreenBlack = Color(0xFF0F0D13) // previously: DarkSurfaceContainerLowest
val DeepCharcoalGray = Color(0xFF1D1B20) // previously: SurfaceContainerLow
val CharcoalGray = Color(0xFF1D1B20) // previously: SurfaceContainer
val DarkSlateGray = Color(0xFF2B2930) // previously: DarkSurfaceContainerHigh
val DustyGray = Color(0xFF79747E) // previously: SchemesOutline

val DeepVioletGray = Color(0xFF333846) // previously: LightPrimary
val LavenderGray = Color(0xFFCCC2DC) // previously: SecondaryFixedDim
val PaleLavender = Color(0xFFE6E0E9) // previously: DarkOnSurface
val SoftLilac = Color(0xFFEADDF5) // previously: PrimaryContainer
val LightLavender = Color(0xFFECE6F0) // previously: LightSurfaceContainerHigh

val CrimsonRed = Color(0xFFB3261E) // previously: SchemesError
val DeepIndigo = Color(0xFF21005D) // previously: OnPrimaryFixed

// Gradients
val PurpleLight1 = Color(0xFFD0BCFE)
val PurpleMedium1 = Color(0xFFD0BCFE) // same as PurpleLight1
val PurpleLight2 = Color(0xFFD0BCFE) // same as PurpleLight1
val PurpleMedium2 = Color(0xFFD0BCFE) // same as PurpleLight1

val GradientStartDefault = Color(0xFFEADDF5) // Button-gradient-default start
val GradientEndDefault = Color(0xFFD0BCFE) // Button-gradient-default end

val GradientStartPressed = Color(0xFFE0D0FA) // Button-gradient-pressed start
val GradientEndPressed = Color(0xFFAD90F1) // Button-gradient-pressed end

// Gradients
val ButtonGradientDefault = Brush.linearGradient(
    colors = listOf(GradientStartDefault, GradientEndDefault)
)

val ButtonGradientPressed = Brush.linearGradient(
    colors = listOf(GradientStartPressed, GradientEndPressed)
)