package dev.prateekthakur.dragonballencyclopedia.ui.utils

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Int.Space(){
    return Spacer(modifier = Modifier.size(this.dp))
}