package com.htk.ytubevideo.features.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.htk.ytubevideo.core.components.TextView
import com.htk.ytubevideo.core.ui.color.YTubeColors
import com.htk.ytubevideo.core.utils.OnBackPressed
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun SetupHomeScreen(
    navHost: NavHostController,
    homeViewModel: HomeViewModel = koinViewModel()
) {
    homeViewModel.setController(navHost)


    OnBackPressed(disableBackPressed = true)

    SetupHomeScreenBody(homeViewModel)
}

@Composable
internal fun SetupHomeScreenBody(homeViewModel: HomeViewModel) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    bottom = innerPadding.calculateBottomPadding(),
                    top = innerPadding.calculateTopPadding(),
                    start = 0.dp,
                    end = 0.dp
                )
                .background(color = Color.Black)
                .verticalScroll(rememberScrollState()),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextView(text = "oiii", color = Color.Black, fontSize = 42.sp)
        }
    }
}