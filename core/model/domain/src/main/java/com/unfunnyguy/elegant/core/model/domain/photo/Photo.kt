package com.unfunnyguy.elegant.core.model.domain.photo

import com.unfunnyguy.elegant.core.model.domain.user.User

data class Photo(
    val blurHash: String,
    val color: String,
    val createdAt: String?,
    val description: String?,
    val height: Int?,
    val id: String,
    val likes: Int?,
    val sponsorship: Boolean = false,
    val urls: Urls,
    val user: User,
    val width: Int
)

data class Urls(
    val full: String,
    val raw: String,
    val regular: String,
    val small: String,
    val thumb: String
)
