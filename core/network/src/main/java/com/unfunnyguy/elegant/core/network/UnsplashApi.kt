package com.unfunnyguy.elegant.core.network

import com.unfunnyguy.elegant.core.model.network.photo.PhotoDto
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashApi {

    @GET("users/unfunnyguy/likes")
    suspend fun getCuratedWalls(
        @Query("page") page: Int,
        @Query("per_page") pageLimit: Int = 30,
    ): List<PhotoDto>

    @GET("photos")
    suspend fun getNormalWalls(
        @Query("page") page: Int,
        @Query("per_page") pageLimit: Int = 30,
        @Query("order_by") orderBy: String = "latest",
    ): List<PhotoDto>

}