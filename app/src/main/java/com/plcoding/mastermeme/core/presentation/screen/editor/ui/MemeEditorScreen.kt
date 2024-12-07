package com.plcoding.mastermeme.core.presentation.screen.editor.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.plcoding.mastermeme.core.presentation.screen.editor.OnUIMemeEditorEvent
import com.plcoding.mastermeme.core.presentation.screen.editor.UIMemeEditorState
import com.plcoding.mastermeme.core.presentation.ui.text.TextH1

@Composable
fun MemeEditorScreen(uiState: UIMemeEditorState, onEvent: OnUIMemeEditorEvent) {
    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        TextH1(text = "Editor", color = Color.White)
    }
}
