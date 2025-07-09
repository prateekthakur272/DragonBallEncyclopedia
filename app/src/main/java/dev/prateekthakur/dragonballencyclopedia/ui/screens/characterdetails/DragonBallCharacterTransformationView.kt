package dev.prateekthakur.dragonballencyclopedia.ui.screens.characterdetails

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.prateekthakur.dragonballencyclopedia.domain.models.DragonBallCharacterTransformation
import dev.prateekthakur.dragonballencyclopedia.ui.composables.NetworkImage

@Composable
fun DragonBallCharacterTransformationView(
    transformation: DragonBallCharacterTransformation, modifier: Modifier = Modifier
) {
    Box(contentAlignment = Alignment.Center) {
        Column(modifier = modifier.padding(16.dp)) {
            Text(transformation.name, style = MaterialTheme.typography.titleLarge)
            Text(transformation.ki, style = MaterialTheme.typography.bodyMedium)
            Box(contentAlignment = Alignment.BottomCenter) {
                Canvas(modifier = modifier.height(100.dp).width(300.dp)) {
                    drawOval(color = Color.Gray.copy(alpha = 0.5f))
                }
                NetworkImage(transformation.image!!, modifier = modifier.padding(bottom = 24.dp).height(300.dp).fillMaxWidth())
            }
        }
    }
}