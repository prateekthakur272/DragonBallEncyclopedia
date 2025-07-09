package dev.prateekthakur.dragonballencyclopedia.domain.models

data class DragonBallCharacterTransformation(
    val id: Int,
    val name: String,
    val image: String?,
    val ki: String,
    val deletedAt: String?
)
