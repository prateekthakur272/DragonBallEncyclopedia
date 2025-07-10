package dev.prateekthakur.dragonballencyclopedia.domain.models

data class DragonBallPlanet(
    val id: Int,
    val name: String,
    val description: String,
    val image: String,
    val isDestroyed: Boolean,
    val characters: List<DragonBallCharacter>?
)