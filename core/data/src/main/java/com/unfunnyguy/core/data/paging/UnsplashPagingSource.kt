package com.unfunnyguy.core.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.unfunnyguy.core.data.mapper.toPhoto
import com.unfunnyguy.core.domain.model.photo.Photo
import com.unfunnyguy.elegant.core.network.UnsplashApi

class UnsplashPagingSource(private val apiService: UnsplashApi) : PagingSource<Int, Photo>() {
    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        return try {
            val page = params.key ?: 1
            val response =
                apiService.getCuratedWalls(page = page, 15).map {
                    it.toPhoto()
                }

            LoadResult.Page(
                data = response,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.isEmpty()) null else page.plus(1),
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
