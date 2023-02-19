package com.unfunnyguy.elegant.core.ui.utils.extensions

import androidx.compose.ui.graphics.Color

fun Color.Companion.parse(colorString: String): Color =
    Color(color = android.graphics.Color.parseColor(colorString))

