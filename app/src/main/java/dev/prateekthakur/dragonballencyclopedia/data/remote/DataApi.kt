package dev.prateekthakur.dragonballencyclopedia.data.remote

import dev.prateekthakur.dragonballencyclopedia.data.dto.ResponseDto
import dev.prateekthakur.dragonballencyclopedia.domain.models.DragonBallCharacter
import dev.prateekthakur.dragonballencyclopedia.domain.models.DragonBallPlanet
import retrofit2.http.GET
import retrofit2.http.Query

interface DataApi {
    @GET(ApiEndpoints.PLANETS)
    suspend fun getPlanets(@Query("page") page: Int, @Query("limit") limit: Int) : ResponseDto<DragonBallPlanet>

    @GET(ApiEndpoints.CHARACTERS)
    suspend fun getCharacters(@Query("page") page: Int, @Query("limit") limit: Int) : ResponseDto<DragonBallCharacter>
}