package com.plcoding.mastermeme.core.presentation.screen.editor.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.plcoding.mastermeme.core.presentation.screen.editor.OnUIMemeEditorEvent
import com.plcoding.mastermeme.core.presentation.screen.editor.RootViewState
import com.plcoding.mastermeme.core.presentation.screen.editor.UIMemeEditorState
import com.plcoding.mastermeme.feature_editor.presentation.UIAddTextState
import com.plcoding.mastermeme.feature_editor.presentation.UIEditTextState
import com.plcoding.mastermeme.feature_editor.presentation.ui.FooterAddTextView

@Composable
fun BottomEditOptions(
    uiState: UIMemeEditorState,
    addTextState: UIAddTextState,
    editTextState: UIEditTextState,
    onEvent: OnUIMemeEditorEvent
) {
    Box(
        Modifier
            .background(color = MaterialTheme.colorScheme.surfaceContainerLow)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        when (uiState.rootViewState) {
            RootViewState.AddTextView -> FooterAddTextView(addTextState, onEvent)
            RootViewState.ModifyTextView -> FooterModifyTextView(editTextState,onEvent)
        }
    }
}