import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import com.plcoding.mastermeme.core.presentation.screen.editor.OnAddTextPanelEvent
import com.plcoding.mastermeme.core.presentation.screen.editor.UIAddTextPanelEvent
import com.plcoding.mastermeme.core.presentation.ui.text.TextH1
import com.plcoding.mastermeme.feature_editor.presentation.TextEntryMetaData

@Composable
fun EditableText(
    textData: TextEntryMetaData,
    containerWidth: Float,
    containerHeight: Float,
    onEvent: OnAddTextPanelEvent
) {
    val density = LocalDensity.current
    val containerCorrectionWidth: Dp = with(density) { -containerWidth.div(2).toDp() }
    val containerCorrectionHeight: Dp = with(density) { -containerHeight.div(2).toDp() }

    val externalOffsetX = with(density) { ((textData.posX * containerWidth).toDp()) }
    val externalOffsetY = with(density) { (textData.posY * containerHeight).toDp() }

    var localOffsetX by remember { mutableStateOf<Dp?>(null) }
    var localOffsetY by remember { mutableStateOf<Dp?>(null) }

    var lastClickTime by remember { mutableLongStateOf(0L) }
    val doubleClickTimeWindow = 300L // Time window for double click in milliseconds

    var textCorrectionX by remember { mutableIntStateOf(0) }
    var textCorrectionY by remember { mutableIntStateOf(0) }

    Box(Modifier.wrapContentSize()) {
        TextH1(
            text = textData.currentText,
            modifier = Modifier
                .wrapContentSize()
                .offset(
                    x = (localOffsetX ?: externalOffsetX) + containerCorrectionWidth,
                    y = (localOffsetY ?: externalOffsetY) + containerCorrectionHeight
                )
                .onGloballyPositioned {
                    textCorrectionX = -it.size.width.div(2)
                    textCorrectionY = -it.size.height.div(2)
                }
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = {
                            val currentTime = System.currentTimeMillis()
                            if (currentTime - lastClickTime < doubleClickTimeWindow) {
                                // Double click detected
                                onEvent(UIAddTextPanelEvent.OnTextDoubleClicked)
                            } else {
                                // Single click detected
                                onEvent(UIAddTextPanelEvent.OnTextClicked(textData))
                            }
                            lastClickTime = currentTime
                        }
                    )
                }
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consume()

                        val newOffsetX =
                            (localOffsetX
                                ?: externalOffsetX) + with(density) { dragAmount.x.toDp() }
                        val newOffsetY =
                            (localOffsetY
                                ?: externalOffsetY) + with(density) { dragAmount.y.toDp() }

                        val maxX = with(density) { containerWidth.toDp() + textCorrectionX.toDp() }
                        val maxY = with(density) { containerHeight.toDp() + textCorrectionY.toDp() }

                        localOffsetX = newOffsetX.coerceIn(-textCorrectionX.toDp(), maxX)
                        localOffsetY = newOffsetY.coerceIn(-textCorrectionY.toDp(), maxY)
                    }
                },
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}