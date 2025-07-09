package dev.prateekthakur.dragonballencyclopedia.ui.screens.characterdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.prateekthakur.dragonballencyclopedia.domain.models.DragonBallCharacterDetails
import dev.prateekthakur.dragonballencyclopedia.domain.repository.DragonBallDataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    val repository: DragonBallDataRepository
) : ViewModel() {

    private val _character = MutableStateFlow<DragonBallCharacterDetails?>(null)
    val character = _character.asStateFlow()

    init {
        val characterId: Int = checkNotNull(savedStateHandle["id"])
        getCharacterDetails(characterId)
    }

    private fun getCharacterDetails(id: Int) {
        viewModelScope.launch {
            val data = repository.getCharacter(id).getOrNull()
            _character.update { data }
        }
    }
}