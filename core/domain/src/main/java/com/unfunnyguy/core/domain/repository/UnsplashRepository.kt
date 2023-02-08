package com.unfunnyguy.core.domain.repository

import androidx.paging.PagingData
import com.unfunnyguy.core.domain.model.photo.Photo
import kotlinx.coroutines.flow.Flow

interface UnsplashRepository {

    fun getCuratedWalls(): Flow<PagingData<Photo>>

}