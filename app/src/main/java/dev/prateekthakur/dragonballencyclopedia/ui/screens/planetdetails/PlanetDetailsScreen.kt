package dev.prateekthakur.dragonballencyclopedia.ui.screens.planetdetails

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.prateekthakur.dragonballencyclopedia.ui.composables.InfoChip
import dev.prateekthakur.dragonballencyclopedia.ui.composables.NetworkImage
import dev.prateekthakur.dragonballencyclopedia.ui.navigation.AppRoutes
import dev.prateekthakur.dragonballencyclopedia.ui.navigation.navController
import dev.prateekthakur.dragonballencyclopedia.ui.utils.Space

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlanetDetailsScreen(
    modifier: Modifier = Modifier, viewModel: PlanetDetailsViewModel = hiltViewModel()
) {


    val planetState by viewModel.planet.collectAsState()

    val appBar = @Composable {
        TopAppBar(title = {}, navigationIcon = {
            IconButton(onClick = {
                navController.popBackStack()
            }) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        })
    }

    Scaffold(topBar = appBar) { scaffoldPadding ->
        Box(modifier = modifier.padding(scaffoldPadding)) {
            planetState?.let { planet ->
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth()
                ) {
                    item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                        Column {
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
                                if (planet.isDestroyed) InfoChip(
                                    "Destroyed", color = MaterialTheme.colorScheme.error
                                )
                            }
                            16.Space()
                            Text(
                                text = planet.description,
                                style = MaterialTheme.typography.bodyMedium
                            )
                            24.Space()
                        }
                    }

                    planet.characters?.let { characters ->

                        if (characters.isNotEmpty()) item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                            Text(
                                "Characters from ${planet.name}",
                                style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.primary)
                            )
                        }

                        items(characters.size) {
                            val character = characters[it]
                            Box(modifier = modifier
                                .padding(8.dp)
                                .border(
                                    width = 1.dp,
                                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f),
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .padding(8.dp)
                                .clickable {
                                    navController.navigate(
                                        AppRoutes.CharacterDetails.create(
                                            character.id
                                        )
                                    )
                                }) {
                                Column(
                                    modifier = modifier.fillMaxSize(),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    NetworkImage(
                                        character.image,
                                        modifier = modifier.height(160.dp)
                                    )
                                    Text(
                                        "${character.name} - ${character.affiliation}",
                                        style = MaterialTheme.typography.titleMedium,
                                        textAlign = TextAlign.Center
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}