package com.htk.ytubevideo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.navigation.compose.composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.htk.ytubevideo.core.navigation.RouterNavigationEnum
import com.htk.ytubevideo.core.ui.AppTheme
import com.htk.ytubevideo.core.utils.ChangeStatusBar
import com.htk.ytubevideo.features.home.SetupHomeScreen
import com.htk.ytubevideo.features.login.presentation.SetupLoginScreen
import com.htk.ytubevideo.features.splash.presentation.SetupSplashScreen


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ChangeStatusBar()
            AppTheme().AppTheme {
                val navController = rememberAnimatedNavController()
                AnimatedNavHost(
                    navController = navController,
                    startDestination = RouterNavigationEnum.SPLASH_SCREEN.name
                ) {
                    composable(
                        RouterNavigationEnum.SPLASH_SCREEN.name,
                    ) {
                        SetupSplashScreen(navController)
                    }
                    composable(RouterNavigationEnum.LOGIN_SCREEN.name, enterTransition = {
                        when (targetState.destination.route) {
                            RouterNavigationEnum.LOGIN_SCREEN.name -> {
                                slideIntoContainer(
                                    AnimatedContentTransitionScope.SlideDirection.Left,
                                    animationSpec = tween(700)
                                )
                            }

                            else -> null
                        }
                    }) {
                        SetupLoginScreen(navHost = navController)
                    }

                    composable(RouterNavigationEnum.HOME_SCREEN.name, enterTransition = {
                        when (targetState.destination.route) {
                            RouterNavigationEnum.HOME_SCREEN.name -> {
                                slideIntoContainer(
                                    AnimatedContentTransitionScope.SlideDirection.Left,
                                    animationSpec = tween(700)
                                )
                            }

                            else -> null
                        }
                    }) {
                        SetupHomeScreen(navController)
                    }
                }
            }
        }
    }
}




