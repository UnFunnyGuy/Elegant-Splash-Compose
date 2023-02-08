package com.unfunnyguy.elegant.core.network

import com.unfunnyguy.elegant.core.network.model.photo.PhotoDto
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashApi {

    @GET("users/unfunnyguy/likes")
    suspend fun getCuratedWalls(
        @Query("page") page: Int,
        @Query("per_page") pageLimit: Int,
    ): List<PhotoDto>

}