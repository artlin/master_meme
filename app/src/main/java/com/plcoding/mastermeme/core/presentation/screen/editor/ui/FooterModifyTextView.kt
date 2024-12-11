package com.plcoding.mastermeme.core.presentation.screen.editor.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.plcoding.mastermeme.core.presentation.screen.editor.OnUIMemeEditorEvent
import com.plcoding.mastermeme.core.presentation.screen.editor.UIEditTextPanelEvent
import com.plcoding.mastermeme.core.presentation.screen.editor.UIEditTextPanelEvent.*
import com.plcoding.mastermeme.core.presentation.screen.editor.UIMemeEditorEvent
import com.plcoding.mastermeme.core.presentation.ui.button.ButtonWithBgSelection
import com.plcoding.mastermeme.core.presentation.ui.button.CancelXButton
import com.plcoding.mastermeme.core.presentation.ui.button.CheckmarkButton
import com.plcoding.mastermeme.core.presentation.ui.button.ColorPickerButton
import com.plcoding.mastermeme.core.presentation.ui.button.TextSizeButton
import com.plcoding.mastermeme.core.presentation.ui.button.TextStyleButton
import com.plcoding.mastermeme.feature_editor.presentation.SelectedEditOption
import com.plcoding.mastermeme.feature_editor.presentation.UIEditTextState

@Composable
fun FooterModifyTextView(editTextState: UIEditTextState, onEvent: OnUIMemeEditorEvent) {
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

@Composable
fun OptionButtons(editTextState: UIEditTextState, onEvent: OnUIMemeEditorEvent) {
    val sizes = 48.dp
    val selectedIndex = when (editTextState.currentOption) {
        SelectedEditOption.None -> 0
        is SelectedEditOption.TextStyle -> 1
        is SelectedEditOption.TextSize -> 2
        is SelectedEditOption.ColorPicker -> 3
    }
    Row {
        ButtonWithBgSelection(
            Modifier.clickable { onEvent(OnStyleOptionClicked) },
            isSelected = selectedIndex == 1
        ) {
            TextStyleButton(Modifier.size(sizes))
        }
        ButtonWithBgSelection(
            Modifier.clickable { onEvent(OnSizeOptionClicked) },
            isSelected = selectedIndex == 2
        ) {
            TextSizeButton(Modifier.size(sizes))
        }
        ButtonWithBgSelection(
            Modifier.clickable { onEvent(OnPickerOptionClicked) },
            isSelected = selectedIndex == 3
        ) {
            ColorPickerButton(Modifier.size(sizes))
        }

    }
}
