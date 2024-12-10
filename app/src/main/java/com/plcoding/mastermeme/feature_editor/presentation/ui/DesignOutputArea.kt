package com.plcoding.mastermeme.feature_editor.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.plcoding.mastermeme.core.presentation.screen.editor.OnUIMemeEditorEvent
import com.plcoding.mastermeme.feature_templates.domain.TemplateData
import com.plcoding.mastermeme.feature_templates.presentation.ui.TemplateAssetImage

@Composable
fun DesignOutputArea(modifier: Modifier, template: TemplateData?, onEvent: OnUIMemeEditorEvent) {
    Box(
        modifier = modifier
    ) {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

            TemplateAssetImage(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .aspectRatio(1f),
                assetPath = template?.imageLocation
            )
        }
    }
}