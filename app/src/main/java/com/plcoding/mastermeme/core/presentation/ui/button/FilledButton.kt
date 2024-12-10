package com.plcoding.mastermeme.core.presentation.ui.button

import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.mastermeme.core.presentation.ui.text.TextButton

@Composable
fun FilledTextButton(modifier: Modifier, text: String, onClick: () -> Unit) {
    Button(
        modifier = modifier.clickable { onClick() },
        onClick = { /* Handle click */ },
        shape = RoundedCornerShape(8.dp),
    ) {
        TextButton(text = text, color = MaterialTheme.colorScheme.onPrimary)
    }
}

@Preview(apiLevel = 33, device = Devices.PIXEL_4, widthDp = 360)
@Composable
fun PreviewFilledTextButton() {
    HollowTextButton(modifier = Modifier, text = "Button Text", onClick = {})
}