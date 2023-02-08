package com.unfunnyguy.core.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.unfunnyguy.core.data.mapper.toPhoto
import com.unfunnyguy.core.data.paging.ElegantPagingSource
import com.unfunnyguy.core.domain.repository.UnsplashRepository
import com.unfunnyguy.elegant.core.network.UnsplashApi
import javax.inject.Inject

class UnsplashRepositoryImpl @Inject constructor(private val apiService :UnsplashApi ) :
    UnsplashRepository {
    override  fun getCuratedWalls() = Pager(
        config = PagingConfig(30),
        pagingSourceFactory = {
            ElegantPagingSource{ page ->
                apiService.getCuratedWalls(page, pageLimit = 30).map {
                    it.toPhoto()
                }
            }
        }
    ).flow
}