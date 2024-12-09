package com.plcoding.mastermeme.core.presentation.screen.editor.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.plcoding.mastermeme.R
import com.plcoding.mastermeme.core.presentation.screen.editor.OnUIMemeEditorEvent
import com.plcoding.mastermeme.core.presentation.screen.editor.UIMemeEditorState
import com.plcoding.mastermeme.core.presentation.ui.button.BackButton
import com.plcoding.mastermeme.core.presentation.ui.text.TextH1
import com.plcoding.mastermeme.feature_templates.presentation.ui.TemplateAssetImage

@Composable
fun MemeEditorScreen(uiState: UIMemeEditorState, onEvent: OnUIMemeEditorEvent) {
    Scaffold { inset ->
        Column(
            Modifier
                .background(color = MaterialTheme.colorScheme.surfaceContainerLowest)
                .padding(inset)
                .fillMaxSize()
        ) {
            Header()
            uiState.tempTemplate?.imageLocation?.let {
                TemplateAssetImage(
                    modifier = Modifier.size(50.dp),
                    assetPath = it
                )
            }
        }
    }
}

@Composable
fun Header() {
    Row(
        Modifier
            .background(color = MaterialTheme.colorScheme.surfaceContainerLow)
            .fillMaxWidth()
            .height(64.dp).padding(horizontal = 30.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        BackButton(Modifier.size(16.dp))
        TextH1(
            text = stringResource(R.string.new_meme),
            color = MaterialTheme.colorScheme.onSurface
        )
        BackButton(Modifier.size(16.dp).alpha(.0f))
    }
}
