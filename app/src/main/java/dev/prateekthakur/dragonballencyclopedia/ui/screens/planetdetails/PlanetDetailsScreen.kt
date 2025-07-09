package dev.prateekthakur.dragonballencyclopedia.ui.screens.planetdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.prateekthakur.dragonballencyclopedia.ui.composables.InfoChip
import dev.prateekthakur.dragonballencyclopedia.ui.composables.NetworkImage
import dev.prateekthakur.dragonballencyclopedia.ui.navigation.navController
import dev.prateekthakur.dragonballencyclopedia.ui.utils.Space

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlanetDetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: PlanetDetailsViewModel = hiltViewModel()
) {


    val planetState by viewModel.planet.collectAsState()

    val appBar = @Composable {
        TopAppBar(
            title = {},
            navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            })}

    Scaffold(topBar = appBar) { scaffoldPadding ->
        Box(modifier = modifier.padding(scaffoldPadding)) {
            planetState?.let { planet ->
                Column(
                    modifier = modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {
                    NetworkImage(
                        planet.image,
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Crop,
                        cornerRadius = 16
                    )
                    24.Space()
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = planet.name,
                            style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.primary),
                            fontWeight = FontWeight.SemiBold
                        )
                        if (planet.isDestroyed)
                            InfoChip("Destroyed", color = MaterialTheme.colorScheme.error)
                    }
                    16.Space()
                    Text(text = planet.description, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}