package com.htk.ytubevideo.core.extensions

import com.htk.ytubevideo.core.utils.Mapper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

fun <T> CoroutineScope.launchScopedFun(
    data: Flow<T>,
    onCollect: (T) -> Unit,
    onStart: (() -> Unit)? = null,
    onCompletion: (() -> Unit)? = null,
    onCatch: ((Throwable?) -> Unit)? = null,
) {
    launch {
        data.onStart { onStart?.invoke() }
            .onCompletion { onCompletion?.invoke() }
            .catch { onCatch?.invoke(it) }
            .collect {
                onCollect.invoke(it)
            }
    }
}