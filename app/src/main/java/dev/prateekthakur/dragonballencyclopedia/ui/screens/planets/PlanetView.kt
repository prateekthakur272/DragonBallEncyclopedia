package dev.prateekthakur.dragonballencyclopedia.ui.screens.planets

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.prateekthakur.dragonballencyclopedia.domain.models.DragonBallPlanet
import dev.prateekthakur.dragonballencyclopedia.ui.composables.InfoChip
import dev.prateekthakur.dragonballencyclopedia.ui.composables.NetworkImage

@Composable
fun PlanetView(planet: DragonBallPlanet, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .border(
                1.dp,
                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f),
                RoundedCornerShape(16.dp)
            )
    ) {
        Column(modifier = modifier.fillMaxWidth()) {
            NetworkImage(
                url = planet.image,
                modifier = modifier
                    .height(200.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Column(modifier = modifier.padding(16.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier.fillMaxWidth()
                ) {
                    Text(text = planet.name, style = MaterialTheme.typography.titleLarge)
                    if (planet.isDestroyed)
                        InfoChip("Destroyed", color = MaterialTheme.colorScheme.error.copy(alpha = 0.7f))
                }
                HorizontalDivider(modifier = modifier.padding(vertical = 8.dp))
                Text(text = planet.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PlanetViewPreview() {
    val planet = DragonBallPlanet(
        id = 1,
        name = "Earth",
        description = "Earth is a planet",
        image = "https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png",
        isDestroyed = false
    )
    PlanetView(planet)
}