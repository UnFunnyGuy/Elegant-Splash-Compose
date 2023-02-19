package com.unfunnyguy.elegant.ui.home.screens

import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.LazyPagingItems
import com.unfunnyguy.elegant.core.model.domain.photo.Photo
import com.unfunnyguy.elegant.core.ui.components.PhotoCard
import com.unfunnyguy.elegant.core.ui.composables.ElegantPagingLazyColumn

@Composable
fun PhotoPagingList(
    modifier: Modifier = Modifier,
    walls: LazyPagingItems<Photo>
) {
    ElegantPagingLazyColumn(
        modifier = modifier,
        lazyListState = rememberLazyListState(),
        list = walls,
        itemKey = { it.id }
    ) {
        it?.let {
            PhotoCard(modifier = Modifier, url = it.urls.regular, placeHolderColor = it.color)
        }
    }
}

