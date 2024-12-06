package com.plcoding.mastermeme.core.presentation.ui.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.plcoding.mastermeme.core.presentation.ui.theme.LocalTextStyleTokens

@Composable
fun TextBodyBig(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        modifier = modifier,
        textAlign = textAlign,
        text = text,
        color = color,
        style = LocalTextStyleTokens.current.bodyBig
    )
}

@Composable
fun TextBodyRegular(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        modifier = modifier,
        textAlign = textAlign,
        text = text,
        color = color,
        style = LocalTextStyleTokens.current.bodyRegular
    )
}

@Composable
fun TextBodyMedium(
    modifier: Modifier = Modifier,
    text: String,
    color: Color,
    textAlign: TextAlign = TextAlign.Start
) {
    Text(
        modifier = modifier,
        textAlign = textAlign,
        text = text,
        color = color,
        style = LocalTextStyleTokens.current.bodyMedium
    )
}