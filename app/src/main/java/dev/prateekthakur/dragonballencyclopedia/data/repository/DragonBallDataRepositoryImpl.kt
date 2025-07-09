package dev.prateekthakur.dragonballencyclopedia.data.repository

import android.util.Log
import dev.prateekthakur.dragonballencyclopedia.data.remote.DataApi
import dev.prateekthakur.dragonballencyclopedia.domain.models.DragonBallCharacter
import dev.prateekthakur.dragonballencyclopedia.domain.models.DragonBallCharacterDetails
import dev.prateekthakur.dragonballencyclopedia.domain.models.DragonBallPlanet
import dev.prateekthakur.dragonballencyclopedia.domain.repository.DragonBallDataRepository
import javax.inject.Inject

class DragonBallDataRepositoryImpl @Inject constructor (private val dataApi: DataApi) : DragonBallDataRepository {

    private suspend fun <T> inResult(apiCall: suspend () -> T): Result<T> {
        return try {
            val result = apiCall()
            Result.success(result)
        } catch (e: Exception) {
            Log.d("PopulationRepositoryImpl", e.toString())
            Result.failure(e)
        }
    }

    override suspend fun getPlanets(page: Int, limit: Int): Result<List<DragonBallPlanet>> {
        return inResult {
            val data = dataApi.getPlanets(page, limit)
            data.items
        }
    }

    override suspend fun getCharacters(page: Int, limit: Int): Result<List<DragonBallCharacter>> {
        return inResult {
            val data = dataApi.getCharacters(page, limit)
            data.items
        }
    }

    override suspend fun getCharacter(id: Int): Result<DragonBallCharacterDetails> {
        return inResult { dataApi.getCharacter(id) }
    }
}