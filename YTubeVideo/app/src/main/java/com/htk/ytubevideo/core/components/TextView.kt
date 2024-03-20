package com.htk.ytubevideo.core.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.TextUnit
import com.htk.ytubevideo.core.components.utils.Padding

@Composable
fun TextView(
    text: String, color: Color, fontSize: TextUnit, padding: Padding = Padding(),
    textStyle: TextStyle = MaterialTheme.typography.body1
) {
    Text(
        text = text,
        fontSize = fontSize,
        modifier = Modifier.padding(
            top = padding.top,
            bottom = padding.bottom,
            end = padding.end,
            start = padding.start
        ),
        style = textStyle,
        color = color
    )
}