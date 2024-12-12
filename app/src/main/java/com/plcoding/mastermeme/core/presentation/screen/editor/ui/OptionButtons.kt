package com.plcoding.mastermeme.core.presentation.screen.editor.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.plcoding.mastermeme.core.presentation.screen.editor.OnUIEditTextPanelEvent
import com.plcoding.mastermeme.core.presentation.screen.editor.OnUIMemeEditorEvent
import com.plcoding.mastermeme.core.presentation.screen.editor.UIEditTextPanelEvent
import com.plcoding.mastermeme.core.presentation.ui.button.ButtonWithBgSelection
import com.plcoding.mastermeme.core.presentation.ui.button.ColorPickerButton
import com.plcoding.mastermeme.core.presentation.ui.button.TextSizeButton
import com.plcoding.mastermeme.core.presentation.ui.button.TextStyleButton
import com.plcoding.mastermeme.feature_editor.presentation.SelectedEditOption
import com.plcoding.mastermeme.feature_editor.presentation.UIEditTextState

@Composable
fun OptionButtons(editTextState: UIEditTextState, onEvent: OnUIEditTextPanelEvent) {
    val sizes = 48.dp
    val selectedIndex = when (editTextState.currentOption) {
        SelectedEditOption.None -> 0
        is SelectedEditOption.OptionStyle -> 1
        is SelectedEditOption.OptionSize -> 2
        is SelectedEditOption.OptionPicker -> 3
    }
    Row {
        ButtonWithBgSelection(
            Modifier.clickable { onEvent(UIEditTextPanelEvent.OnStyleOptionClicked) },
            isSelected = selectedIndex == 1
        ) {
            TextStyleButton(Modifier.size(sizes))
        }
        ButtonWithBgSelection(
            Modifier.clickable { onEvent(UIEditTextPanelEvent.OnSizeOptionClicked) },
            isSelected = selectedIndex == 2
        ) {
            TextSizeButton(Modifier.size(sizes))
        }
        ButtonWithBgSelection(
            Modifier.clickable { onEvent(UIEditTextPanelEvent.OnPickerOptionClicked) },
            isSelected = selectedIndex == 3
        ) {
            ColorPickerButton(Modifier.size(sizes))
        }

    }
}