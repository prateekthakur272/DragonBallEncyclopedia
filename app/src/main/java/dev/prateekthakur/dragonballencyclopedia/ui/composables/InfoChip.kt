package dev.prateekthakur.dragonballencyclopedia.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun InfoChip(value: String, color: Color = MaterialTheme.colorScheme.secondary) {
    Box(
        Modifier
            .border(
                0.5.dp,
                color.copy(alpha = 0.7f),
                RoundedCornerShape(16.dp)
            )
            .padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Text(
            text = value,
            style = MaterialTheme.typography.labelMedium.copy(color = color)
        )
    }
}