package com.plcoding.mastermeme.core.presentation.screen.editor.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.plcoding.mastermeme.core.presentation.screen.editor.OnUIMemeEditorEvent
import com.plcoding.mastermeme.core.presentation.screen.editor.RootViewState
import com.plcoding.mastermeme.core.presentation.screen.editor.UIMemeEditorState
import com.plcoding.mastermeme.core.presentation.ui.button.RedoButton
import com.plcoding.mastermeme.core.presentation.ui.button.UndoButton
import com.plcoding.mastermeme.core.presentation.ui.text.TextBodyRegular
import com.plcoding.mastermeme.core.presentation.ui.text.TextH2
import com.plcoding.mastermeme.feature_editor.presentation.ui.ConfirmationDialog
import com.plcoding.mastermeme.feature_editor.presentation.ui.DesignOutputArea

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
            BottomEditOption(uiState)
        }

        if (uiState.isExitConfirmationDialogVisible) ConfirmationDialog(onEvent)
    }
}

@Composable
fun BottomEditOption(uiState: UIMemeEditorState) {
    Box(
        Modifier
            .background(color = MaterialTheme.colorScheme.surfaceContainerLow)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        when (uiState.rootViewState) {
            RootViewState.AddTextView -> BottomAddTextView()
            RootViewState.ModifyTextView -> BottomModifyTextView()
        }
    }
}

@Composable
fun BottomAddTextView() {
    val arrowModifiers = Modifier
        .width(24.dp)
        .aspectRatio(1f)
    Row(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            Modifier.padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            UndoButton(modifier = arrowModifiers, isActive = false)
            RedoButton(modifier = arrowModifiers, isActive = false)
        }
    }
}

@Composable
fun BottomModifyTextView() {

}

