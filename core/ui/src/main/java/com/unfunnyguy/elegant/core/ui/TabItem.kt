package com.unfunnyguy.elegant.core.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable

@Immutable
data class TabItem(
    val title: String,
    val screen: @Composable () -> Unit,
)
