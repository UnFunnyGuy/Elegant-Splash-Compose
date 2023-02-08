package com.unfunnyguy.elegant.core.network.model.user

import com.google.gson.annotations.SerializedName

data class UserDto(
    val bio: String?,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("for_hire")
    val forHire: Boolean?,
    val id: String,
    @SerializedName("instagram_username")
    val instagramUsername: String?,
    @SerializedName("last_name")
    val lastName: String?,
    val location: String?,
    val name: String?,
    @SerializedName("profile_image")
    val profileImage: ProfileImageDto,
    @SerializedName("total_collections")
    val totalCollections: Int?,
    @SerializedName("total_likes")
    val totalLikes: Int?,
    @SerializedName("total_photos")
    val totalPhotos: Int?,
    @SerializedName("twitter_username")
    val twitterUsername: String?,
    @SerializedName("updated_at")
    val updatedAt: String?,
    val username: String?
)

data class ProfileImageDto(
    val large: String,
    val medium: String,
    val small: String
)