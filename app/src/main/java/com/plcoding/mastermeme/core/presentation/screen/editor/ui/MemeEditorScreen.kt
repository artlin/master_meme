package com.plcoding.mastermeme.core.presentation.screen.editor.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.plcoding.mastermeme.core.presentation.screen.editor.OnUIMemeEditorEvent
import com.plcoding.mastermeme.core.presentation.screen.editor.UIMemeEditorState

@Composable
fun MemeEditorScreen(uiState: UIMemeEditorState, onEvent: OnUIMemeEditorEvent) {
    Scaffold { inset ->
        DesignOutputArea(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surfaceContainerLowest)
                .padding(inset), template = uiState.tempTemplate, onEvent
        )
        Column(
            Modifier
                .padding(inset)
                .fillMaxSize()
        ) {
            Header(onEvent)
            Spacer(Modifier.weight(1f))
            BottomEditOption()
        }

        if (uiState.isExitConfirmationDialogVisible) ConfirmationDialog(onEvent)
    }
}

@Composable
fun BottomEditOption() {
    Row(
        Modifier
            .background(color = MaterialTheme.colorScheme.surfaceContainerLow)
            .fillMaxWidth()
            .height(48.dp)
    ) {

    }
}
