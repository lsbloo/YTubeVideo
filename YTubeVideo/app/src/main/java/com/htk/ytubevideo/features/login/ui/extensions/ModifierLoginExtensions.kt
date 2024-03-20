package com.htk.ytubevideo.features.login.ui.extensions

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

fun Modifier.customTextFieldLogin(): Modifier {
    return this
        .fillMaxWidth()
        .padding(start = 24.dp, end = 24.dp)
        .height(64.dp)
}