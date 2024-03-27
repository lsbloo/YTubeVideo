package com.htk.ytubevideo.features.splash.presentation

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.htk.ytubevideo.core.base.onViewModelAction
import org.koin.androidx.compose.koinViewModel


@Composable
internal fun SetupSplashScreen(
    navHost: NavHostController,
    splashViewModel: SplashViewModel = koinViewModel()
) {
    splashViewModel.setController(navHost)
    splashViewModel.rotateSplashPlayerAnimated()

    splashViewModel.onViewModelAction {
        when (it) {
            is SplashScreenAction.NavigateToLogin -> {
                splashViewModel.navigateToLogin()
            }
        }
    }

    BodySplashScreen(splashViewModel)
}


@Composable
internal fun BodySplashScreen(splashViewModel: SplashViewModel) {
    val colors = listOf(Color.Red, Color(0xFF0277fe))

    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = Color.Black),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Canvas(
                modifier = Modifier.size(200.dp)
            ) {
                val trianglePath = Path().let {
                    it.moveTo(this.size.width * .40f, this.size.height * .67f)
                    it.lineTo(this.size.width * .40f, this.size.height * .30f)
                    it.lineTo(this.size.width * .75f, this.size.height * .50f)
                    it.close()
                    it
                }
                val rect = Rect(Offset.Zero, size)
                drawCircle(color = Color.Black)
                rotate(degrees = splashViewModel.mutableStateOffset.value, rect.center) {
                    drawPath(
                        path = trianglePath,
                        Brush.verticalGradient(colors = colors),
                        style = Stroke(width = 15f, cap = StrokeCap.Round)
                    )
                }

            }
        }
    }

}

@Composable
@Preview
internal fun BodySplashScreenPreview() {
    val colors = listOf(Color.Red, Color(0xFF0277fe))
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Canvas(
            modifier = Modifier.size(200.dp)
        ) {
            val trianglePath = Path().let {
                it.moveTo(this.size.width * .40f, this.size.height * .67f)
                it.lineTo(this.size.width * .40f, this.size.height * .30f)
                it.lineTo(this.size.width * .75f, this.size.height * .50f)
                it.close()
                it
            }
            val rect = Rect(Offset.Zero, size)
            drawCircle(color = Color.Black)

            rotate(degrees = 0f, rect.center) {
                drawPath(
                    path = trianglePath,
                    Brush.verticalGradient(colors = colors),
                    style = Stroke(width = 15f, cap = StrokeCap.Round)
                )
            }

        }
    }
}
