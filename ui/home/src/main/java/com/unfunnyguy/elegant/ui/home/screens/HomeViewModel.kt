package com.unfunnyguy.elegant.ui.home.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.unfunnyguy.core.domain.use_cases.UnsplashUseCases
import com.unfunnyguy.elegant.core.model.domain.photo.Photo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val useCases: UnsplashUseCases) : ViewModel() {


    fun getCuratedWalls(): Flow<PagingData<Photo>> =
        useCases.getCuratedWalls().cachedIn(viewModelScope)

    fun getNormalWalls(): Flow<PagingData<Photo>> =
        useCases.getNormalWalls().cachedIn(viewModelScope)
}
