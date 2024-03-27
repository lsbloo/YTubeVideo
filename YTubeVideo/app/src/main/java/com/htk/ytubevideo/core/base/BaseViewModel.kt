package com.htk.ytubevideo.core.base

import androidx.compose.runtime.Composable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.htk.ytubevideo.core.extensions.onAction
import com.htk.ytubevideo.core.extensions.onState
import com.htk.ytubevideo.core.navigation.RouterNavigation

open class BaseViewModel<Action : UIAction, State : UIState>(
    private val routerNavigation: RouterNavigation,
    initialState: State
) :
    ViewModel() {

    fun setController(navHostController: NavHostController) {
        routerNavigation.setNavController(navHostController)
    }

    private val _mutableState = MutableLiveData<State>()

    private val _mutableAction = MutableLiveData<Action>()

    init {
        _mutableState.value = initialState
    }

    fun setState(state: () -> State) {
        _mutableState.value = state.invoke()
    }

    fun sendAction(action: () -> Action) {
        _mutableAction.value = action.invoke()
    }

    var state: LiveData<State> = _mutableState

    var action: LiveData<Action> = _mutableAction

}

@Composable
fun BaseViewModel<out UIAction, out UIState>.onViewModelAction(block: (UIAction) -> Unit) =
    action.onAction { block.invoke(it) }

@Composable
fun BaseViewModel<out UIAction, out UIState>.onViewModelState(block: @Composable UIState.() -> Unit) =
    state.onState { block.invoke(this) }


