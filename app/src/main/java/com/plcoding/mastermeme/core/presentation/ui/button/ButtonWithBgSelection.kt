package com.plcoding.mastermeme.core.presentation.ui.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ButtonWithBgSelection(
    modifier: Modifier,
    isSelected: Boolean,
    content: @Composable () -> Unit
) {
    val selectionBg = when (isSelected) {
        true -> Modifier.background(
            color = MaterialTheme.colorScheme.surfaceContainerHigh,
            shape = RoundedCornerShape(12.dp)
        )

        false -> Modifier
    }
    Box(modifier.then(selectionBg), contentAlignment = Alignment.Center) {
        content()
    }
}