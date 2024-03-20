package com.htk.ytubevideo.core.navigation

import androidx.navigation.NavHostController

interface RouterNavigation {
    fun setNavController(navController: NavHostController)
    fun navigateTo(dest: RouterNavigationEnum)
    fun navigateAndPop(dest: RouterNavigationEnum)
}