package dev.prateekthakur.dragonballencyclopedia.ui.screens.planets

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.prateekthakur.dragonballencyclopedia.domain.models.DragonBallPlanet
import dev.prateekthakur.dragonballencyclopedia.domain.repository.DragonBallDataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanetsViewModel
@Inject constructor(private val dataRepository: DragonBallDataRepository) : ViewModel() {

    private val _planets = MutableStateFlow<List<DragonBallPlanet>>(emptyList())
    val planets: StateFlow<List<DragonBallPlanet>> = _planets

    init {
        getPlanets()
    }

    private fun getPlanets(page: Int = 1, limit: Int = 10) {
        viewModelScope.launch {
            _planets.update {
                dataRepository.getPlanets(page, limit).getOrNull() ?: emptyList()
            }
            Log.d("PlanetsViewModel", "getCharacters: ${planets.value.size}")
        }
    }
}