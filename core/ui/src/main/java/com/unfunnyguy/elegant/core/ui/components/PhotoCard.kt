package com.unfunnyguy.elegant.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.unfunnyguy.elegant.core.ui.utils.extensions.parse

@Composable
fun PhotoCard(modifier: Modifier, url: String, placeHolderColor: String) {
    AsyncImage(
        modifier =
            modifier.padding(6.dp).size(width = 290.dp, height = 360.dp).background(
                color = Color.parse(placeHolderColor),
                shape = RoundedCornerShape(10.dp)
            ).clip(RoundedCornerShape(10.dp)),
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .crossfade(true)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}
