package com.unfunnyguy.core.domain.model.user

data class User(
    val bio: String?,
    val firstName: String,
    val id: String,
    val lastName: String?,
    val name: String?,
    val profileImage: ProfileImage,
    val username: String?
)

data class ProfileImage(
    val large: String,
    val medium: String,
    val small: String
)
