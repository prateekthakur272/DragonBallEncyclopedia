package dev.prateekthakur.dragonballencyclopedia.ui.screens.planetdetails

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.prateekthakur.dragonballencyclopedia.domain.models.DragonBallPlanet
import dev.prateekthakur.dragonballencyclopedia.domain.repository.DragonBallDataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanetDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val repository: DragonBallDataRepository
) : ViewModel() {

    private val _planet = MutableStateFlow<DragonBallPlanet?>(null)
    val planet = _planet.asStateFlow()

    init {
        val id = savedStateHandle.get<Int>("id")!!
        getPlanet(id)
    }

    private fun getPlanet(id: Int){
        viewModelScope.launch {
            _planet.update { repository.getPlanet(id).getOrNull() }
        }
    }
}