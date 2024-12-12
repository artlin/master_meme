package com.plcoding.mastermeme.core.presentation.screen.editor.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.plcoding.mastermeme.core.presentation.screen.editor.OnUIEditTextPanelEvent
import com.plcoding.mastermeme.core.presentation.screen.editor.OnUIMemeEditorEvent
import com.plcoding.mastermeme.core.presentation.screen.editor.UIEditTextPanelEvent
import com.plcoding.mastermeme.core.presentation.screen.editor.UIMemeEditorEvent
import com.plcoding.mastermeme.core.presentation.ui.button.CancelXButton
import com.plcoding.mastermeme.core.presentation.ui.button.CheckmarkButton
import com.plcoding.mastermeme.core.presentation.ui.button.LettersBig
import com.plcoding.mastermeme.core.presentation.ui.button.LettersSmall
import com.plcoding.mastermeme.feature_editor.presentation.SelectedEditOption
import com.plcoding.mastermeme.feature_editor.presentation.TextSizeState
import com.plcoding.mastermeme.feature_editor.presentation.UIEditTextState

@Composable
fun FooterModifyTextView(editTextState: UIEditTextState, onEvent: OnUIMemeEditorEvent) {
    Column {
        ButtonPanels(editTextState, onEvent)
        Row(
            Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            CancelXButton(
                modifier = Modifier
                    .size(14.dp)
                    .clickable { onEvent(UIMemeEditorEvent.OnEditCancelClicked) })
            OptionButtons(editTextState, onEvent)
            CheckmarkButton(modifier = Modifier.size(14.dp))
        }
    }
}

@Composable
fun ButtonPanels(editTextState: UIEditTextState, onEvent: OnUIEditTextPanelEvent) {

    Box(
        Modifier
            .background(color = MaterialTheme.colorScheme.surfaceContainerLow)
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        when (editTextState.currentOption) {
            SelectedEditOption.None -> Unit
            is SelectedEditOption.OptionStyle -> {}
            is SelectedEditOption.OptionPicker -> {}

            is SelectedEditOption.OptionSize -> TextSizePanel(editTextState.textSizeState, onEvent)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextSizePanel(sizeState: TextSizeState, onEvent: OnUIEditTextPanelEvent) {
    val sizes = 36.dp
    var sliderValue by remember { mutableFloatStateOf(sizeState.uiProgress) }
    // State to track if thumb is pressed
    var isThumbPressed by remember { mutableStateOf(false) }

    val interactionSource = remember { MutableInteractionSource() }

    // Listen to interactions globally
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            when (interaction) {
                is PressInteraction.Press -> isThumbPressed = true
                is PressInteraction.Release, is DragInteraction.Cancel -> isThumbPressed = false
                is DragInteraction.Start -> isThumbPressed = true
            }
        }
    }
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        LettersSmall(Modifier.size(sizes))
        Slider(
            value = sliderValue,
            onValueChange = { newValue ->
                sliderValue = newValue // Update the slider value
                onEvent(UIEditTextPanelEvent.FonSizeChanged(newValue))
            },
            valueRange = 0f..1f,
            steps = 32,
            track = { CustomSliderTrack(it) },
            thumb = { CustomSliderThumb(isThumbPressed) },
            interactionSource = interactionSource,
            modifier = Modifier
                .padding(vertical = 2.dp)
                .weight(1f)
        )
        LettersBig(Modifier.size(sizes))
    }
}

@Composable
fun CustomSliderThumb(isThumbPressed: Boolean) {
    val color = MaterialTheme.colorScheme.onSecondary.copy(alpha = 0.2f)
    val alpha = if (isThumbPressed) 1f else 0f
    Box(contentAlignment = Alignment.Center) {
        HalfCircleBackground(
            Modifier
                .size(32.dp)
                .offset(x = (0).dp, y = (16).dp)
                .alpha(alpha), color
        )
        Box(
            Modifier
                .size(16.dp)
                .background(color = MaterialTheme.colorScheme.onSecondary, shape = CircleShape)
        )
        HalfCircleBackground(
            Modifier
                .size(32.dp)
                .rotate(180f)
                .offset(x = (0).dp, y = (16).dp)
                .alpha(alpha), color
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSliderTrack(sliderState: SliderState) {
    Box(
        Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(color = MaterialTheme.colorScheme.onSecondary)
    )
}

@Composable
fun HalfCircleBackground(modifier: Modifier = Modifier, color: Color = Color.Blue) {
    Canvas(modifier = modifier) {
        val radius = size.width// Calculate radius based on the width
        drawArc(
            color = color,
            startAngle = 180f, // Start angle for the half-circle
            sweepAngle = 180f, // Sweep angle to draw half-circle
            useCenter = true, // Close the arc to the center
            size = size.copy(height = radius), // Restrict height to half
            topLeft = Offset(0f, size.height / 2 - radius) // Align top of arc
        )
    }
}


