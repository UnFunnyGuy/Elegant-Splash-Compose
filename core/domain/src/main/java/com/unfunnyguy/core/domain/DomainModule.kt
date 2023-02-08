package com.unfunnyguy.core.domain

import com.unfunnyguy.core.domain.repository.UnsplashRepository
import com.unfunnyguy.core.domain.use_cases.GetCuratedWalls
import com.unfunnyguy.core.domain.use_cases.UnsplashUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun providesUnsplashUseCases(repository: UnsplashRepository) =
        UnsplashUseCases(getCuratedWalls = GetCuratedWalls(repository))
}
