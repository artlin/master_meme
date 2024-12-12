import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.plcoding.mastermeme.core.presentation.screen.editor.OnAddTextPanelEvent
import com.plcoding.mastermeme.core.presentation.screen.editor.UIAddTextPanelEvent
import com.plcoding.mastermeme.core.presentation.ui.text.TextH1
import com.plcoding.mastermeme.feature_editor.domain.TextEntryMetaData
import com.plcoding.mastermeme.feature_editor.presentation.TextEntryVisualState
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.UUID

@Composable
fun EditableText(
    textData: TextEntryMetaData,
    containerWidth: Float,
    containerHeight: Float,
    onEvent: OnAddTextPanelEvent
) {
    val density = LocalDensity.current

    val externalOffsetX = with(density) { ((textData.posX * containerWidth).toDp()) }
    val externalOffsetY = with(density) { (textData.posY * containerHeight).toDp() }

    var localOffsetX by remember { mutableStateOf<Dp?>(null) }
    var localOffsetY by remember { mutableStateOf<Dp?>(null) }

    // Key the remembers to this specific text instance
    var lastClickTime by remember(textData.uid) { mutableLongStateOf(0L) }
    var waitingForDoubleClick by remember(textData.uid) { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()

    val doubleClickTimeWindow = 300L

    var textWidth by remember { mutableIntStateOf(0) }
    var textHeight by remember { mutableIntStateOf(0) }

    val movableModifier = Modifier
        .offset {
            IntOffset(
                x = (localOffsetX ?: externalOffsetX).roundToPx(),
                y = (localOffsetY ?: externalOffsetY).roundToPx()
            )
        }
        .onGloballyPositioned {
            textWidth = it.size.width
            textHeight = it.size.height
        }
        .pointerInput(UUID.randomUUID()) {
            detectDragGestures(
                onDragEnd = {
                    val finalX = (localOffsetX ?: externalOffsetX)
                    val finalY = (localOffsetY ?: externalOffsetY)

                    val newPosX = with(density) {
                        (finalX).toPx() / containerWidth
                    }
                    val newPosY = with(density) {
                        (finalY).toPx() / containerHeight
                    }

                    onEvent(
                        UIAddTextPanelEvent.OnDragEnd(
                            textEntryMetaData = textData,
                            newPosX = newPosX.coerceIn(0f, 1f),
                            newPosY = newPosY.coerceIn(0f, 1f)
                        )
                    )
                },
                onDrag = { change, dragAmount ->
                    change.consume()
                    waitingForDoubleClick = false  // Cancel any pending single click

                    val newOffsetX =
                        (localOffsetX ?: externalOffsetX) + with(density) { dragAmount.x.toDp() }
                    val newOffsetY =
                        (localOffsetY ?: externalOffsetY) + with(density) { dragAmount.y.toDp() }

                    val maxX = with(density) { containerWidth.toDp() - textWidth.toDp() }
                    val maxY = with(density) { containerHeight.toDp() - textHeight.toDp() }

                    localOffsetX = newOffsetX.coerceIn(0.dp, maxX)
                    localOffsetY = newOffsetY.coerceIn(0.dp, maxY)
                }
            )
        }

    val tapModifier = Modifier.pointerInput(UUID.randomUUID()) {
        detectTapGestures(
            onTap = {
                println(textData.currentText)
                onEvent(UIAddTextPanelEvent.OnTextClicked(textData))
                val currentTime = System.currentTimeMillis()
                if (currentTime - lastClickTime < doubleClickTimeWindow) {
                    // Double click detected
                    waitingForDoubleClick = false
                    onEvent(UIAddTextPanelEvent.OnTextDoubleClicked(textData))
                } else {

                    // Potential single click
                    waitingForDoubleClick = true
                    coroutineScope.launch {
                        delay(doubleClickTimeWindow)
                        if (waitingForDoubleClick) {
                            waitingForDoubleClick = false
                            onEvent(UIAddTextPanelEvent.OnTextClicked(textData))
                        }
                    }
                }
                lastClickTime = currentTime
            }
        )
    }

    val clickableModifier = Modifier.clickable {
        onEvent(UIAddTextPanelEvent.OnTextClicked(textData))
    }

    val testOffsetModifier = Modifier.offset {
        IntOffset(
            x = (localOffsetX ?: externalOffsetX).roundToPx(),
            y = (localOffsetY ?: externalOffsetY).roundToPx()
        )
    }

    val backgroundModifier = when (textData.visualState) {
        TextEntryVisualState.Focused, TextEntryVisualState.Editing -> Modifier
            .background(color = Color.Transparent)
            .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(4.dp))

        TextEntryVisualState.Normal -> Modifier
    }
    Box(
        Modifier
            .wrapContentSize()
            .then(movableModifier)
//            .then(testOffsetModifier)
            .then(tapModifier)
            .then(backgroundModifier).padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        TextH1(
            text = textData.currentText,
            modifier = Modifier.wrapContentSize(),
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}
