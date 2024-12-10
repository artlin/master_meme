package com.plcoding.mastermeme.core.presentation.ui.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.plcoding.mastermeme.core.presentation.ui.text.TextButton

@Composable
fun HollowTextButton(modifier: Modifier, text: String, onClick: () -> Unit) {
    OutlinedButton(
        modifier = modifier,
        onClick = { onClick() },
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.5f)),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.Transparent
        )
    ) {
        TextButton(text = text, color = MaterialTheme.colorScheme.primary)
    }
}

@Preview(apiLevel = 33, device = Devices.PIXEL_4, widthDp = 360)
@Composable
fun PreviewHollowTextButton() {
    HollowTextButton(modifier = Modifier, text = "Button Text", onClick = {})
}