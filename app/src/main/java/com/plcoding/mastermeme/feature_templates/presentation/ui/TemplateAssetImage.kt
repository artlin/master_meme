package com.plcoding.mastermeme.feature_templates.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import coil.size.Size
import com.plcoding.mastermeme.core.domain.value.ImageLocation

@Composable
fun TemplateAssetImage(modifier: Modifier, assetPath: ImageLocation, isThumbnail: Boolean = false) {

    val context = LocalContext.current
    val imageRequest = ImageRequest.Builder(context)
        .data("file:///android_asset/${assetPath.value}")
        .memoryCachePolicy(CachePolicy.ENABLED)
        .diskCachePolicy(CachePolicy.ENABLED)
        .size(Size.ORIGINAL)
        .allowHardware(true)
        .crossfade(true)

    if (isThumbnail) {
        val size = 200
        imageRequest.size(size, size)
        imageRequest.allowRgb565(true)
    }

    AsyncImage(
        model = imageRequest.build(),
        contentDescription = null,
        modifier = modifier,
        alignment = Alignment.Center,
        contentScale = ContentScale.Crop
    )
}