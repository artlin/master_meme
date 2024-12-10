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
fun UndoButton(modifier: Modifier, isActive: Boolean) {
    Box(modifier = modifier) {
        Icon(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.icon_back_arrow),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSecondary.copy(if (isActive) 1f else .3f)
        )
    }
}