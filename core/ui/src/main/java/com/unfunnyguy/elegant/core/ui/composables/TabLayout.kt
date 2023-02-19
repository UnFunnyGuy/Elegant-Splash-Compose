package com.unfunnyguy.elegant.core.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.TabRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import com.unfunnyguy.elegant.core.ui.TabItem
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabLayout(tabItems: List<TabItem>) {
    //TODO: Use dimens
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()

    Column {
        TabRow(
            selectedTabIndex = pagerState.currentPage,
            backgroundColor = MaterialTheme.colorScheme.background,
            indicator = { tabPositions ->
                Box(
                    Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
                        .background(
                            color = MaterialTheme.colorScheme.primary,
                            shape = RoundedCornerShape(18.dp)
                        )
                        .height(3.dp)
                )
            },
            modifier = Modifier.fillMaxWidth().wrapContentHeight()
        ) {
            tabItems.forEachIndexed { index, _ ->
                Tab(
                    selected = pagerState.currentPage == index,
                    onClick = { scope.launch { pagerState.animateScrollToPage(index) } },
                    text = {
                        Text(
                            text = tabItems[index].title,
                            color =
                            if (pagerState.currentPage == index) {
                                MaterialTheme.colorScheme.primary
                            } else MaterialTheme.colorScheme.onBackground
                        )
                    }
                )
            }
        }

        HorizontalPager(
            count = tabItems.size, state = pagerState
        ) { index ->
            tabItems[index].screen()
        }
    }
}
