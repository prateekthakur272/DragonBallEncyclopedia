package dev.prateekthakur.dragonballencyclopedia.ui.screens.characters

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import dev.prateekthakur.dragonballencyclopedia.domain.models.DragonBallCharacter
import dev.prateekthakur.dragonballencyclopedia.ui.composables.NetworkImage
import dev.prateekthakur.dragonballencyclopedia.ui.utils.Space

@Composable
fun CharacterView(character: DragonBallCharacter, modifier: Modifier = Modifier) {

    Box(modifier = modifier
        .padding(16.dp)
        .clip(RoundedCornerShape(16.dp))
        .border(1.dp, MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f), RoundedCornerShape(16.dp))
    ){
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
                Text(text = character.name, style = MaterialTheme.typography.titleLarge)
                HorizontalDivider(modifier = modifier.padding(vertical = 8.dp))
                Text(text = character.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}