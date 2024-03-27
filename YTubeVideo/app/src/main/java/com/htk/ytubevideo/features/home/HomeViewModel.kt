package com.htk.ytubevideo.features.home

import com.htk.ytubevideo.core.base.BaseViewModel
import com.htk.ytubevideo.core.navigation.RouterNavigation

class HomeViewModel(
    private val routerNavigation: RouterNavigation,
) : BaseViewModel<HomeViewAction, HomeState>(routerNavigation, HomeState()) {
}