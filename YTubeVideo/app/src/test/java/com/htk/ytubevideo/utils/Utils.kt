package com.htk.ytubevideo.utils

import kotlinx.coroutines.flow.Flow
import kotlin.test.assertEquals

suspend fun Flow<Any>.verifyCollect(expected: Any) {
    this@verifyCollect.collect {
        assertEquals(expected, it)
    }
}