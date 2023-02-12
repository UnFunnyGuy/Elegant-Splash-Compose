package com.unfunnyguy.elegant.core.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items

@Composable
fun <T : Any> ElegantPagingLazyColumn(
    modifier: Modifier,
    lazyListState: LazyListState = rememberLazyListState(),
    list: LazyPagingItems<T>?,
    itemKey: ((T) -> Any)? = null,
    content: @Composable() (LazyItemScope.(T?) -> Unit)
) {
    LazyColumn(modifier = modifier, state = lazyListState) {
        list?.let { list ->
            items(
                items = list,
                key = itemKey?.let { k -> { k(it) } } // itemKey is optional
            ) { item ->
                content(item)
            }
        }
        //TODO: Make Changes
        when (val state = list?.loadState?.refresh) { // First Load
            is LoadState.Error -> {
                // TODO Error Item
            }
            is LoadState.Loading -> { // Loading UI
                item {
                    Column(
                        modifier = Modifier.fillParentMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(modifier = Modifier.padding(8.dp), text = "Refresh Loading")

                        CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
                    }
                }
            }
            else -> {}
        }

        when (val state = list?.loadState?.append) { // Pagination
            is LoadState.Error -> {
                // TODO Pagination Error Item
            }
            is LoadState.Loading -> { // Pagination Loading UI
                item {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(text = "Pagination Loading")

                        CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
                    }
                }
            }
            else -> {}
        }
    }
}
