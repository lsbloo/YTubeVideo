package com.htk.ytubevideo.core.navigation

import android.util.Log
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions

class RouterNavigationImpl : RouterNavigation {

    private var navController: NavHostController? = null
    override fun setNavController(navController: NavHostController) {
        Log.d("Controller initialized", "" + navController)
        this.navController = navController
    }

    override fun navigateAndPop(dest: RouterNavigationEnum) {
        navController?.navigate(dest.name, NavOptions.Builder().setPopUpTo(dest.name, false).build())
    }

    override fun navigateTo(dest: RouterNavigationEnum) {
        navController?.navigate(dest.name)
    }
}
