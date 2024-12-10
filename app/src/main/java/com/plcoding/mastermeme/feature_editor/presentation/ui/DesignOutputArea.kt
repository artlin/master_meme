package com.plcoding.mastermeme.feature_editor.presentation.ui

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.plcoding.mastermeme.core.presentation.screen.editor.OnUIMemeEditorEvent
import com.plcoding.mastermeme.core.presentation.ui.text.TextH1
import com.plcoding.mastermeme.feature_editor.presentation.TextEntryMetaData
import com.plcoding.mastermeme.feature_editor.presentation.UIAddTextState
import com.plcoding.mastermeme.feature_templates.domain.TemplateData
import com.plcoding.mastermeme.feature_templates.presentation.ui.TemplateAssetImage

@Composable
fun DesignOutputArea(
    modifier: Modifier,
    template: TemplateData?,
    addTextState: UIAddTextState,
    onEvent: OnUIMemeEditorEvent,
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
                EditableText(it, containerWidth, containerHeight)
            }
        }
    }
}

@Composable
fun EditableText(
    textData: TextEntryMetaData, containerWidth: Float, containerHeight: Float
) {
    val density = LocalDensity.current
    val containerCorrectionWidth: Dp = with(density) { -containerWidth.div(2).toDp() }
    val containerCorrectionHeight: Dp = with(density) { -containerHeight.div(2).toDp() }

    val externalOffsetX = with(density) { ((textData.posX * containerWidth).toDp()) }
    val externalOffsetY = with(density) { (textData.posY * containerHeight).toDp() }

    // Local offsets for drag gestures
    var localOffsetX by remember { mutableStateOf<Dp?>(null) }
    var localOffsetY by remember { mutableStateOf<Dp?>(null) }


    var textCorrectionX by remember { mutableIntStateOf(0) }
    var textCorrectionY by remember { mutableIntStateOf(0) }

    TextH1(
        text = textData.currentText, modifier = Modifier
            .wrapContentSize()
            .offset(
                x = (localOffsetX ?: externalOffsetX) + containerCorrectionWidth,
                y = (localOffsetY ?: externalOffsetY) + containerCorrectionHeight
            )
            .onGloballyPositioned {
                textCorrectionX = -it.size.width.div(2)
                textCorrectionY = -it.size.height.div(2)
                println("Text size : ${it.size}")
            }
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume() // Consume the gesture

                    // Calculate the new offsets
                    val newOffsetX =
                        (localOffsetX
                            ?: externalOffsetX) + with(density) { dragAmount.x.toDp() }
                    val newOffsetY =
                        (localOffsetY
                            ?: externalOffsetY) + with(density) { dragAmount.y.toDp() }

                    // Adjust bounds based on text size
                    val maxX =
                        with(density) {
                            containerWidth.toDp() + textCorrectionX.toDp()
                        }
                    val maxY =
                        with(density) {
                            containerHeight.toDp() + textCorrectionY.toDp()
                        }

                    localOffsetX = newOffsetX.coerceIn(-textCorrectionX.toDp(), maxX)
                    localOffsetY = newOffsetY.coerceIn(-textCorrectionY.toDp(), maxY)
                }
            }, color = MaterialTheme.colorScheme.onSurface
    )
}
