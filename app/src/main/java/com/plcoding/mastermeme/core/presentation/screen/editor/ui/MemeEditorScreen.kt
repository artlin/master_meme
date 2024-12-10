package com.plcoding.mastermeme.core.presentation.screen.editor.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.plcoding.mastermeme.core.presentation.screen.editor.OnUIMemeEditorEvent
import com.plcoding.mastermeme.core.presentation.screen.editor.UIMemeEditorState
import com.plcoding.mastermeme.feature_editor.presentation.UIAddTextState
import com.plcoding.mastermeme.feature_editor.presentation.ui.ConfirmationDialog
import com.plcoding.mastermeme.feature_editor.presentation.ui.DesignOutputArea

@Composable
fun MemeEditorScreen(
    uiRootState: UIMemeEditorState, onEvent: OnUIMemeEditorEvent, addTextState: UIAddTextState
) {
    Scaffold { inset ->
        DesignOutputArea(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colorScheme.surfaceContainerLowest)
                .padding(inset), template = uiRootState.tempTemplate, addTextState, onEvent
        )
        Column(
            Modifier
                .padding(inset)
                .fillMaxSize()
        ) {
            Header(onEvent)
            Spacer(Modifier.weight(1f))
            BottomEditOptions(uiRootState, addTextState, onEvent)
        }

        if (uiRootState.isExitConfirmationDialogVisible) ConfirmationDialog(onEvent)
    }
}

@Composable
fun BottomModifyTextView() {

}

