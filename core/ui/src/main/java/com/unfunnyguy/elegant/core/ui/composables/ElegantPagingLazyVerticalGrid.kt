package com.unfunnyguy.elegant.core.ui.composables

import android.os.Parcel
import android.os.Parcelable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridItemScope
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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

@Composable
fun <T : Any> ElegantPagingLazyVerticalGrid(
    modifier: Modifier,
    lazyListState: LazyListState = rememberLazyListState(),
    list: LazyPagingItems<T>?,
    itemKey: ((T) -> Any)? = null,
    columns: Int = 2,
    content: @Composable() (LazyGridItemScope.(T?) -> Unit)
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
    ) {
        list?.let { list ->
            items(
                items = list,
                key = itemKey?.let { k -> { k(it) } } // itemKey is optional
            ) { item ->
                content(item)
            }
        }

        // TODO: Make Changes
        when (val state = list?.loadState?.refresh) { // First Load
            is LoadState.Error -> {
                // TODO Error Item
            }
            is LoadState.Loading -> { //
                // Loading UI
                item {
                    Column(
                        modifier = Modifier.fillMaxSize(), //TODO: Fix Loading Ui
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

fun <T : Any> LazyGridScope.items(
    items: LazyPagingItems<T>,
    key: ((item: T) -> Any)? = null,
    itemContent: @Composable LazyGridItemScope.(item: T?) -> Unit
) {
    items(
        count = items.itemCount,
        key =
            if (key == null) null
            else
                { index ->
                    val item = items.peek(index)
                    if (item == null) {
                        PagingPlaceholderKey(index)
                    } else {
                        key(item)
                    }
                }
    ) { index ->
        itemContent(items[index])
    }
}

private data class PagingPlaceholderKey(private val index: Int) : Parcelable {
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(index)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {
        @Suppress("unused")
        @JvmField
        val CREATOR: Parcelable.Creator<PagingPlaceholderKey> =
            object : Parcelable.Creator<PagingPlaceholderKey> {
                override fun createFromParcel(parcel: Parcel) =
                    PagingPlaceholderKey(parcel.readInt())

                override fun newArray(size: Int) = arrayOfNulls<PagingPlaceholderKey?>(size)
            }
    }
}
