package dev.prateekthakur.dragonballencyclopedia.ui.screens.planets

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PlanetsPage(modifier: Modifier = Modifier, viewModel: PlanetsViewModel = hiltViewModel()) {

    val planets = viewModel.planets.collectAsState().value

    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            items(planets.size) {
                PlanetView(planet = planets[it])
            }
        }
    }
}

@Preview
@Composable
private fun PlanetsPagePreview() {
    PlanetsPage()
}