package dev.prateekthakur.dragonballencyclopedia.domain.repository

import dev.prateekthakur.dragonballencyclopedia.domain.models.DragonBallCharacter
import dev.prateekthakur.dragonballencyclopedia.domain.models.DragonBallCharacterDetails
import dev.prateekthakur.dragonballencyclopedia.domain.models.DragonBallPlanet

interface DragonBallDataRepository {
    suspend fun getPlanets(page: Int, limit: Int): Result<List<DragonBallPlanet>>
    suspend fun getCharacters(page: Int, limit: Int): Result<List<DragonBallCharacter>>
    suspend fun getCharacter(id: Int): Result<DragonBallCharacterDetails>
    suspend fun getPlanet(id: Int): Result<DragonBallPlanet>
}