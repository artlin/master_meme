package com.plcoding.mastermeme.core.presentation.ui.button

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.plcoding.mastermeme.R

@Composable
fun TextSizeButton(modifier: Modifier) {
    Box(modifier = modifier) {
        Icon(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.icon_text_size),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}