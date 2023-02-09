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

    @GET("photos")
    suspend fun getNormalPhotos(
        @Query("page") page: Int,
        @Query("per_page") pageLimit: Int,
        @Query("order_by") orderBy: String = "latest",
    ): List<PhotoDto>

}