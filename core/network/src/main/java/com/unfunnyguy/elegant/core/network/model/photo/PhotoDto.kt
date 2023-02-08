package com.unfunnyguy.elegant.core.network.model.photo

import com.google.gson.annotations.SerializedName
import com.unfunnyguy.elegant.core.network.model.user.UserDto

data class PhotoDto(
    @SerializedName("blur_hash")
    val blurHash: String,
    val color: String,
    @SerializedName("created_at")
    val createdAt: String?,
    val description: String?,
    val height: Int?,
    val id: String,
    val likes: Int?,
    val sponsorship: String?,
    val urls: UrlsDto,
    val user: UserDto,
    val width: Int
)

data class UrlsDto(
    val full: String,
    val raw: String,
    val regular: String,
    val small: String,
    @SerializedName("small_s3")
    val smallS3: String,
    val thumb: String
)
