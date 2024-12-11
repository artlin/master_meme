package com.plcoding.mastermeme.feature_editor.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.plcoding.mastermeme.R
import com.plcoding.mastermeme.core.presentation.screen.editor.UIAddTextPanelEvent
import com.plcoding.mastermeme.core.presentation.screen.editor.OnUIMemeEditorEvent
import com.plcoding.mastermeme.core.presentation.ui.button.FilledTextButton
import com.plcoding.mastermeme.core.presentation.ui.button.HollowTextButton
import com.plcoding.mastermeme.core.presentation.ui.button.RedoButton
import com.plcoding.mastermeme.core.presentation.ui.button.UndoButton
import com.plcoding.mastermeme.feature_editor.presentation.UIAddTextState

@Composable
fun FooterAddTextView(addTextState: UIAddTextState, onEvent: OnUIMemeEditorEvent) {
    val arrowModifiers = Modifier
        .width(24.dp)
        .aspectRatio(1f)
    Row(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            Modifier.padding(horizontal = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            UndoButton(modifier = arrowModifiers, isActive = false) {
                onEvent(UIAddTextPanelEvent.UndoButtonClicked)
            }
            RedoButton(modifier = arrowModifiers, isActive = false) {
                onEvent(UIAddTextPanelEvent.RedoButtonClicked)
            }
        }
        HollowTextButton(Modifier, stringResource(R.string.add_text), onClick = {
            onEvent(UIAddTextPanelEvent.AddTextClicked)
        })
        FilledTextButton(
            Modifier.wrapContentWidth(),
            stringResource(R.string.save_meme),
            onClick = { onEvent(UIAddTextPanelEvent.SaveMemeClicked) })

    }
}