package dev.prateekthakur.dragonballencyclopedia.ui.screens.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.prateekthakur.dragonballencyclopedia.ui.composables.CheckboxListItem

@Composable
fun SettingsPage(modifier: Modifier = Modifier, viewModel: SettingsViewModel = hiltViewModel()) {

    val pageSize by viewModel.pageSize.collectAsState()

    Box(
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        LazyColumn{
            item {
                Text(
                    "Page Size", style = MaterialTheme.typography.titleMedium
                )
                Text(
                    "Fetch $pageSize items per page", style = MaterialTheme.typography.bodyMedium
                )
                CheckboxListItem("10", checked = pageSize == 10, onCheckedChange = {
                    viewModel.setPageSize(10)
                })
                CheckboxListItem("20", checked = pageSize == 20, onCheckedChange = {
                    viewModel.setPageSize(20)
                })
                CheckboxListItem("30", checked = pageSize == 30, onCheckedChange = {
                    viewModel.setPageSize(30)
                })
            }
        }
    }
}