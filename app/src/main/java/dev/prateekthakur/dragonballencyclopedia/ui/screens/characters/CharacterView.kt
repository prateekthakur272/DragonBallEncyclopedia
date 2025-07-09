package dev.prateekthakur.dragonballencyclopedia.ui.screens.characters

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import dev.prateekthakur.dragonballencyclopedia.domain.models.DragonBallCharacter
import dev.prateekthakur.dragonballencyclopedia.ui.composables.InfoChip
import dev.prateekthakur.dragonballencyclopedia.ui.composables.NetworkImage
import dev.prateekthakur.dragonballencyclopedia.ui.navigation.AppRoutes
import dev.prateekthakur.dragonballencyclopedia.ui.navigation.navController
import dev.prateekthakur.dragonballencyclopedia.ui.utils.Space

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CharacterView(character: DragonBallCharacter, modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .border(
                1.dp,
                MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f),
                RoundedCornerShape(16.dp)
            ).clickable{
                navController.navigate(AppRoutes.CharacterDetails.create(character.id))
            }
    ) {
        Column(modifier = modifier.fillMaxWidth()) {
            16.Space()
            NetworkImage(
                url = character.image,
                modifier = modifier
                    .height(400.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Fit
            )
            Column(modifier = modifier.padding(16.dp)) {
                Text(
                    text = "${character.name} - ${character.affiliation}",
                    style = MaterialTheme.typography.titleLarge
                )
                8.Space()
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(4.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    InfoChip("${character.race}/${character.gender}")
                    InfoChip("KI ${character.ki}")
                    InfoChip("MaxKI ${character.maxKi}")
                }
                8.Space()
                Text(text = character.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}
