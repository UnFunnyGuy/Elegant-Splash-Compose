package com.unfunnyguy.core.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState


class ElegantPagingSource<Type: Any>(
    private val api: suspend (Int)  -> List<Type>
) : PagingSource<Int, Type>() {
    override fun getRefreshKey(state: PagingState<Int, Type>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Type> {
        return try {
            val page = params.key ?: 1
            val response = api(page)

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
