package dev.prateekthakur.dragonballencyclopedia.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@Composable
fun <T> DropdownListItem(
    title: String,
    items: List<T>,
    selectedItem: T?,
    subtitle: String? = null,
    modifier: Modifier = Modifier,
    itemLabel: (T) -> String = { it.toString() },
    onSelected: (T) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Row(verticalAlignment = Alignment.CenterVertically) {
        Column(modifier = modifier.weight(1f)) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium
            )
            if(subtitle!=null){
                Text(
                    text = subtitle,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
        OutlinedButton(
            onClick = { expanded = true },
            shape = RoundedCornerShape(4.dp)
        ) {
            Text(
                text = selectedItem?.let(itemLabel) ?: "Select...",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }

    DropdownMenu(
        expanded = expanded,
        offset = DpOffset(10000.dp,0.dp),
        onDismissRequest = { expanded = false },
    ) {
        items.forEach { item ->
            DropdownMenuItem(
                text = { Text(itemLabel(item)) },
                onClick = {
                    onSelected(item)
                    expanded = false
                }
            )
        }
    }
}