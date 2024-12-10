package com.plcoding.mastermeme.feature_editor.presentation.ui

import EditableText
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.plcoding.mastermeme.core.presentation.screen.editor.OnAddTextPanelEvent
import com.plcoding.mastermeme.feature_editor.presentation.UIAddTextState
import com.plcoding.mastermeme.feature_templates.domain.TemplateData
import com.plcoding.mastermeme.feature_templates.presentation.ui.TemplateAssetImage

@Composable
fun DesignOutputArea(
    modifier: Modifier,
    template: TemplateData?,
    addTextState: UIAddTextState,
    onEvent: OnAddTextPanelEvent,
) {
    Box(
        modifier = modifier, contentAlignment = Alignment.Center
    ) {
        BoxWithConstraints(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .aspectRatio(1f),
            contentAlignment = Alignment.Center
        ) {
            val containerWidth = constraints.maxWidth.toFloat()
            val containerHeight = constraints.maxHeight.toFloat()

            TemplateAssetImage(
                Modifier.fillMaxSize(), assetPath = template?.imageLocation
            )
            addTextState.textEntries.forEach {
                EditableText(it, containerWidth, containerHeight, onEvent)
            }
        }
    }
}

