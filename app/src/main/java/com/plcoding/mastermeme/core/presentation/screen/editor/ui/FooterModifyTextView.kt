package com.plcoding.mastermeme.core.presentation.screen.editor.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.plcoding.mastermeme.feature_editor.presentation.TextSize
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

            is SelectedEditOption.OptionSize -> TextSizePanel(editTextState.textSize, onEvent)
        }
    }
}

@Composable
fun TextSizePanel(sizeState: TextSize, onEvent: OnUIEditTextPanelEvent) {
    val sizes = 36.dp
    var sliderValue by remember { mutableStateOf(sizeState.uiProgress) } // Initial value is 0f
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
            valueRange = 0f..1f, // Set the range of the slider
            steps = 32, // Optional: number of discrete steps (set to 0 for continuous)
            modifier = Modifier
                .padding(vertical = 2.dp)
                .weight(1f)
        )
        LettersBig(Modifier.size(sizes))
    }
}



