package com.htk.ytubevideo.core.extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import com.htk.ytubevideo.core.base.UIAction
import com.htk.ytubevideo.core.base.UIState

@Composable
fun LiveData<out UIAction>.onAction(action: (UIAction) -> Unit) {
    observeAsState().value?.let { action.invoke(it) }
}

@Composable
fun LiveData<out UIState>.onState(state: @Composable UIState.() -> Unit) {
    observeAsState().value?.let { state.invoke(it) }
}