package com.plcoding.mastermeme.core.presentation.screen.editor.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.plcoding.mastermeme.core.presentation.screen.editor.OnUIMemeEditorEvent
import com.plcoding.mastermeme.core.presentation.screen.editor.UIMemeEditorEvent
import com.plcoding.mastermeme.core.presentation.ui.button.CancelXButton
import com.plcoding.mastermeme.core.presentation.ui.button.CheckmarkButton

@Composable
fun BottomModifyTextView(onEvent: OnUIMemeEditorEvent) {
    Row(
        Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CancelXButton(
            modifier = Modifier
                .size(14.dp)
                .clickable { onEvent(UIMemeEditorEvent.OnEditCancelClicked) })
        Spacer(Modifier.weight(1f))
        CheckmarkButton(modifier = Modifier.size(14.dp))
    }
}