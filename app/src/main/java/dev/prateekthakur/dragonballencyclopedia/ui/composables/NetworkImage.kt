package dev.prateekthakur.dragonballencyclopedia.ui.composables

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun NetworkImage(
    url: String,
    modifier: Modifier = Modifier,
    contentDescription: String = "",
    contentScale: ContentScale = ContentScale.Fit,
    cornerRadius: Int = 0
) {
    val context = LocalContext.current
    AsyncImage(
        modifier = modifier.clip(RoundedCornerShape(cornerRadius)),
        model = ImageRequest.Builder(context).data(url).crossfade(true).build(),
        contentDescription = contentDescription,
        contentScale = contentScale
    )
}