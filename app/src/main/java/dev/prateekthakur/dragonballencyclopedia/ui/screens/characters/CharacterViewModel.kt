package dev.prateekthakur.dragonballencyclopedia.ui.screens.characters

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.prateekthakur.dragonballencyclopedia.domain.models.DragonBallCharacter
import dev.prateekthakur.dragonballencyclopedia.domain.repository.DragonBallDataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(private val dataRepository: DragonBallDataRepository) :
    ViewModel() {

    private val _characters = MutableStateFlow<List<DragonBallCharacter>>(emptyList())
    val characters = _characters.asStateFlow()

    private var currentPage = 1
    private var limit = 10

    init {
        loadMore()
    }

    private fun getCharacters(page: Int = 1, limit: Int = 10) {
        viewModelScope.launch {
            val data = dataRepository.getCharacters(page, limit).getOrNull() ?: emptyList()
            _characters.update {
                it + data
            }
            Log.d("CharacterViewModel", "getCharacters: ${characters.value.size}")
        }
    }

    fun loadMore() {
        getCharacters(currentPage++, limit)
    }
}