package dev.prateekthakur.dragonballencyclopedia.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.prateekthakur.dragonballencyclopedia.data.repository.DragonBallDataRepositoryImpl
import dev.prateekthakur.dragonballencyclopedia.domain.repository.DragonBallDataRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindDragonBallDataRepository(
        impl: DragonBallDataRepositoryImpl
    ): DragonBallDataRepository
}