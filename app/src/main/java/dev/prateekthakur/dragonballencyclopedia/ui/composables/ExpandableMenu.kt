package dev.prateekthakur.dragonballencyclopedia.ui.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.prateekthakur.dragonballencyclopedia.ui.utils.Space

@Composable
fun ExpandableMenu(
    modifier: Modifier = Modifier,
    header: @Composable () -> Unit,
    items: @Composable () -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    Box(
        modifier = modifier.border(
            width = 1.dp,
            color = MaterialTheme.colorScheme.outline,
            shape = RoundedCornerShape(16.dp)
        ).padding(16.dp)
    ) {
        Column {
            Surface(
                modifier = modifier.fillMaxWidth(),
                onClick = { expanded = !expanded }) {
                header()
            }
            if (expanded)
                Column {
                    8.Space()
                    items()
                }
        }
    }
}