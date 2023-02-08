package com.unfunnyguy.core.data

import com.unfunnyguy.core.data.repository.UnsplashRepositoryImpl
import com.unfunnyguy.core.domain.repository.UnsplashRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindsUnsplashRepository(
        unsplashRepositoryImpl: UnsplashRepositoryImpl
    ): UnsplashRepository

}