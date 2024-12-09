package com.plcoding.mastermeme.core.presentation.screen.editor.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.plcoding.mastermeme.core.presentation.screen.editor.OnUIMemeEditorEvent
import com.plcoding.mastermeme.core.presentation.screen.editor.UIMemeEditorState

@Composable
fun MemeEditorScreen(uiState: UIMemeEditorState, onEvent: OnUIMemeEditorEvent) {
    Scaffold { inset ->
        Column(
            Modifier
                .background(color = MaterialTheme.colorScheme.surfaceContainerLowest)
                .padding(inset)
                .fillMaxSize()
        ) {
            Header(onEvent)
            DesignOutputArea(template = uiState.tempTemplate, onEvent)

        }
        if (uiState.isExitConfirmationDialogVisible) ConfirmationDialog(onEvent)
    }
}
