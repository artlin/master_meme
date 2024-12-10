package com.plcoding.mastermeme.feature_editor.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.plcoding.mastermeme.R
import com.plcoding.mastermeme.core.presentation.screen.editor.OnUIMemeEditorEvent
import com.plcoding.mastermeme.core.presentation.screen.editor.UIMemeEditorEvent
import com.plcoding.mastermeme.core.presentation.ui.text.TextBodyMedium
import com.plcoding.mastermeme.core.presentation.ui.text.TextButton
import com.plcoding.mastermeme.core.presentation.ui.text.TextH3

@Composable
fun ConfirmationDialog(onEvent: OnUIMemeEditorEvent) {
    Dialog(onDismissRequest = { }) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            shape = RoundedCornerShape(16.dp),
            tonalElevation = 8.dp
        ) {
            Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                TextH3(
                    modifier = Modifier,
                    text = stringResource(R.string.confirm),
                    color = MaterialTheme.colorScheme.onSurface
                )
                TextBodyMedium(
                    Modifier,
                    stringResource(R.string.are_you_sure_you_want_to_discard_changes),
                    color = MaterialTheme.colorScheme.onSurface
                )
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Button(onClick = { onEvent(UIMemeEditorEvent.OnDialogConfirmDiscardClicked) }) {
                        TextButton(
                            modifier = Modifier,
                            text = stringResource(R.string.discard),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Button(onClick = { onEvent(UIMemeEditorEvent.OnDialogConfirmCancelClicked) }) {
                        TextButton(
                            modifier = Modifier,
                            text = stringResource(R.string.cancel),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
            }

        }
    }
}