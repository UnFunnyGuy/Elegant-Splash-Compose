package com.unfunnyguy.elegant.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.unfunnyguy.core.domain.model.photo.Photo
import com.unfunnyguy.core.domain.use_cases.UnsplashUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val useCases: UnsplashUseCases) : ViewModel() {

     fun getCuratedWalls(): Flow<PagingData<Photo>> =
        useCases.getCuratedWalls().cachedIn(viewModelScope)
}
