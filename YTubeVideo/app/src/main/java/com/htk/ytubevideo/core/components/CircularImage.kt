package com.htk.ytubevideo.core.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.htk.ytubevideo.core.components.utils.Padding


@Composable
fun CircularImage(
    imageDrawableId: Int,
    contentDescription: String,
    size: Dp = 64.dp,
    padding: Padding = Padding()
) {
    Image(
        painter = painterResource(id = imageDrawableId),
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(size)
            .clip(CircleShape)
            .padding(
                start = padding.start,
                end = padding.end,
                top = padding.top,
                bottom = padding.bottom
            )
    )
}