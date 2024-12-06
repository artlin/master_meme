package com.plcoding.mastermeme.presentation.screen.your_memes

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.plcoding.mastermeme.presentation.ui.text.TextBodyBig

@Composable
fun YourMemesScreen(uiState: UIStateYourMemes) {

    TextBodyBig(text = "Size of items :${uiState.memeList.size}", color = Color.White)

}
