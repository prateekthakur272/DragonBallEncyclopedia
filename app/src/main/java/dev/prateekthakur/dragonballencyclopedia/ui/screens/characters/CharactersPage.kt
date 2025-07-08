package dev.prateekthakur.dragonballencyclopedia.ui.screens.characters

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CharactersPage(modifier: Modifier = Modifier, viewModel: CharacterViewModel = hiltViewModel()) {

    val characters = viewModel.characters.collectAsState().value

    Box(modifier = modifier.fillMaxSize()) {
        LazyColumn {
            itemsIndexed(characters) { index, character ->
                CharacterView(character)

                if (index >= characters.lastIndex - 2) {
                    viewModel.loadMore()
                }
            }
        }
    }
}