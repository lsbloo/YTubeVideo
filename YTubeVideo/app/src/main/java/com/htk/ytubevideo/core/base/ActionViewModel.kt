package com.htk.ytubevideo.core.base

import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.htk.ytubevideo.core.extensions.onAction
import com.htk.ytubevideo.core.navigation.RouterNavigation

open class ActionViewModel<Action : UIAction>(private val routerNavigation: RouterNavigation) :
    ViewModel() {

    fun setController(navHostController: NavHostController) {
        routerNavigation.setNavController(navHostController)
    }

    private val _mutableAction = MutableLiveData<Action>()

    fun setAction(action: () -> Action) {
        _mutableAction.value = action.invoke()
    }

    var action: LiveData<Action> = _mutableAction
}

@Composable
fun ActionViewModel<out UIAction>.onViewModelAction(block: (UIAction) -> Unit) {
    action.onAction {
        block.invoke(it)
    }
}
