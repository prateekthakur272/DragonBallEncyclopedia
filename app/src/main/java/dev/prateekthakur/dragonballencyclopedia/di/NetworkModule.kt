package dev.prateekthakur.dragonballencyclopedia.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.prateekthakur.dragonballencyclopedia.data.remote.ApiEndpoints
import dev.prateekthakur.dragonballencyclopedia.data.remote.DataApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiEndpoints.BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideDataApi(retrofit: Retrofit): DataApi {
        return retrofit.create(DataApi::class.java)
    }
}