package com.plcoding.mastermeme.core.presentation.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import com.plcoding.mastermeme.R

//val Typography = Typography(
//    bodyLarge = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.5.sp
//    )
//)

val MontserratFamily = FontFamily(
    Font(R.font.montserrat_thin, FontWeight.Thin),
    Font(R.font.montserrat_light, FontWeight.Light),
    Font(R.font.montserrat_regular, FontWeight.Normal),
    Font(R.font.montserrat_medium, FontWeight.Medium),
    Font(R.font.montserrat_semibold, FontWeight.SemiBold),
    Font(R.font.montserrat_bold, FontWeight.Bold),
    Font(R.font.montserrat_extrabold, FontWeight.ExtraBold),
    Font(R.font.montserrat_black, FontWeight.Black)
)

val LocalTextStyleTokens = staticCompositionLocalOf<TemplateTypeTokens> {
    error("No text style tokens provided")
}

class FontTokens : TemplateTypeTokens(
    bodyBig = TextStyle(
        fontFamily = MontserratFamily,
        fontWeight = FontWeight.W400,
        fontSize = TextUnit(20f, TextUnitType.Sp),
    ),
    bodyRegular = TextStyle(
        fontFamily = MontserratFamily,
        fontWeight = FontWeight.W400,
        fontSize = TextUnit(16f, TextUnitType.Sp)
    ),
    bodyMedium = TextStyle(
        fontFamily = MontserratFamily,
        fontWeight = FontWeight.W400,
        fontSize = TextUnit(12f, TextUnitType.Sp)
    ),
    h1 = TextStyle(
        fontFamily = MontserratFamily,
        fontWeight = FontWeight.W500,
        fontSize = TextUnit(24f, TextUnitType.Sp)
    ),
    h2 = TextStyle(
        fontFamily = MontserratFamily,
        fontWeight = FontWeight.W600,
        fontSize = TextUnit(22f, TextUnitType.Sp)
    ),
    h3 = TextStyle(
        fontFamily = MontserratFamily,
        fontWeight = FontWeight.W600,
        fontSize = TextUnit(16f, TextUnitType.Sp)
    ),
    button = TextStyle(
        fontFamily = MontserratFamily,
        fontWeight = FontWeight.W700,
        fontSize = TextUnit(14f, TextUnitType.Sp)
    )
)

@Immutable
open class TemplateTypeTokens(
    open val bodyBig: TextStyle,
    open val bodyRegular: TextStyle,
    open val bodyMedium: TextStyle,
    open val h1: TextStyle,
    open val h2: TextStyle,
    open val h3: TextStyle,
    open val button: TextStyle,
)