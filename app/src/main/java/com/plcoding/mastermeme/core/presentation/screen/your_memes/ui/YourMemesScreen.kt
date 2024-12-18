package com.plcoding.mastermeme.core.presentation.screen.your_memes.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.plcoding.mastermeme.core.presentation.screen.your_memes.OnUIEventYourMemes
import com.plcoding.mastermeme.core.presentation.screen.your_memes.UIEventYourMemes
import com.plcoding.mastermeme.core.presentation.screen.your_memes.UIStateYourMemes
import com.plcoding.mastermeme.core.presentation.ui.text.TextBodyBig

@Composable
fun YourMemesScreen(uiState: UIStateYourMemes, onEvent: OnUIEventYourMemes) {
    Box(
        Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surfaceContainerLowest),
        contentAlignment = Alignment.Center
    ) {
        BottomDrawer(uiState.bottomSheetState, onEvent)
        TextBodyBig(
            modifier = Modifier.clickable {
                onEvent(UIEventYourMemes.OnClick)
            },
            text = "Size of items :${uiState.memeList.size}",
            color = Color.White
        )
    }
}



