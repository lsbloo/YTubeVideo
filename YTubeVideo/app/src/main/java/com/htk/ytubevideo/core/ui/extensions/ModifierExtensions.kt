package com.htk.ytubevideo.core.ui.extensions

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


fun Modifier.modifierCustomButton(): Modifier {
    return this.height(56.dp)
        .fillMaxWidth()
        .padding(start = 24.dp, end = 24.dp)
}