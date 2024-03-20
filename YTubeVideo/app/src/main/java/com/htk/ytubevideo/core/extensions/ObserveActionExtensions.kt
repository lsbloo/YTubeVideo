package com.htk.ytubevideo.core.extensions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import com.htk.ytubevideo.core.base.UIAction

@Composable
fun LiveData<out UIAction>.onAction(action: (UIAction) -> Unit) {
    observeAsState().value?.let { action.invoke(it) }
}