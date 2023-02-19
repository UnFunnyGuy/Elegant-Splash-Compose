package com.unfunnyguy.core.data.mapper

import com.unfunnyguy.elegant.core.model.domain.photo.Photo
import com.unfunnyguy.elegant.core.model.domain.photo.Urls
import com.unfunnyguy.elegant.core.model.domain.user.ProfileImage
import com.unfunnyguy.elegant.core.model.domain.user.User
import com.unfunnyguy.elegant.core.model.network.photo.PhotoDto
import com.unfunnyguy.elegant.core.model.network.photo.UrlsDto
import com.unfunnyguy.elegant.core.model.user.ProfileImageDto
import com.unfunnyguy.elegant.core.model.user.UserDto

fun PhotoDto.toPhoto(): Photo {
    return Photo(
        blurHash = this.blurHash,
        color = this.color,
        createdAt = this.createdAt,
        description = this.description,
        height = this.height,
        id = this.id,
        likes = this.likes,
        sponsorship = this.sponsorship != null,
        urls = this.urls.toUrls(),
        user = this.user.toUser(),
        width = this.width
    )
}

fun UrlsDto.toUrls(): Urls {
    return Urls(
        full = this.full,
        raw = this.raw,
        regular = this.regular,
        small = this.small,
        thumb = this.thumb
    )
}

fun UserDto.toUser(): User {
    return User(
        bio = this.bio,
        firstName = this.firstName,
        id = this.id,
        lastName = this.lastName,
        name = this.name,
        profileImage = this.profileImage.toProfileImage(),
        username = this.username
    )
}

fun ProfileImageDto.toProfileImage(): ProfileImage {
    return ProfileImage(
        large = this.large,
        medium = this.medium,
        small = this.small
    )
}
