package com.plcoding.mastermeme.feature_templates.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.plcoding.mastermeme.core.domain.value.ImageLocation

@Composable
fun TemplateAssetImage(modifier: Modifier, assetPath: ImageLocation) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data("file:///android_asset/${assetPath.value}")
            .crossfade(true)
            .build(),
        contentDescription = null,
        modifier = modifier,
        contentScale = ContentScale.Fit
    )
}