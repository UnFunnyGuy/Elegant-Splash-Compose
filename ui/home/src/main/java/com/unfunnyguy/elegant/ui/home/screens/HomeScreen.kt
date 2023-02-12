package com.unfunnyguy.elegant.ui.home.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.unfunnyguy.elegant.core.ui.TabsItem
import com.unfunnyguy.elegant.core.ui.composables.TabLayout

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {

    val curatedWalls = viewModel.getCuratedWalls().collectAsLazyPagingItems()
    val normalWalls = viewModel.getNormalWalls().collectAsLazyPagingItems()

    val tabItemsList =
        listOf(
            TabsItem("Curated") { PhotoPagingList(walls = curatedWalls) },
            TabsItem("Non Curated") { PhotoPagingList(walls = normalWalls) }
        )

    TabLayout(tabItemsList)
}
