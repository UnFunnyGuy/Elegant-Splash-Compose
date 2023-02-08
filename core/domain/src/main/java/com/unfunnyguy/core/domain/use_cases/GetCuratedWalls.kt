package com.unfunnyguy.core.domain.use_cases

import com.unfunnyguy.core.domain.repository.UnsplashRepository

class GetCuratedWalls(private val repository: UnsplashRepository) {
     operator fun invoke() = repository.getCuratedWalls()

}