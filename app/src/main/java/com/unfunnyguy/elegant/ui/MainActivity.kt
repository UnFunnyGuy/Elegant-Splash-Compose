package com.unfunnyguy.elegant.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.unfunnyguy.elegant.core.ui.components.PhotoCard
import com.unfunnyguy.elegant.ui.theme.ElegantSplashComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ElegantSplashComposeTheme {

                val viewModel = hiltViewModel<MainViewModel>()

                val walls = viewModel.getCuratedWalls().collectAsLazyPagingItems()

                LazyColumn {
                    items(items = walls, key = { it.id }) { wall ->

                        wall?.let {
                            PhotoCard(
                                modifier = Modifier,
                                url = it.urls.regular,
                                placeHolderColor = it.color
                            )
                        }
                        Divider()
                    }

                    when (val state = walls.loadState.refresh) {
                       is LoadState.Error -> {

                        }
                        is LoadState.Loading -> {
                            item {
                                Column(
                                    modifier = Modifier.fillParentMaxSize(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                ) {
                                    Text(
                                        modifier = Modifier.padding(8.dp),
                                        text = "Refresh Loading"
                                    )

                                    CircularProgressIndicator(color = Color.Black)
                                }
                            }
                        }
                        else -> {}
                    }

                    when (val state = walls.loadState.append) {
                        is LoadState.Error -> {
                            
                        }
                        is LoadState.Loading -> { // Pagination Loading UI
                            item {
                                Column(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center,
                                ) {
                                    Text(text = "Pagination Loading")

                                    CircularProgressIndicator(color = Color.Black)
                                }
                            }
                        }
                        else -> {}
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(text = "Hello $name!", modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ElegantSplashComposeTheme { Greeting("Android") }
}
