package com.htk.ytubevideo.core.utils

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.htk.ytubevideo.core.ui.color.YTubeColors

@Composable
fun ChangeStatusBar(color: Long = YTubeColors.DIMGRAY_COLOR) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color(color),
            darkIcons = false
        )
    }
}

@Composable
fun OnBackPressed(disableBackPressed: Boolean = false, action: (() -> Unit)? = null) {
    BackHandler(disableBackPressed) {
        action?.invoke()
    }
}