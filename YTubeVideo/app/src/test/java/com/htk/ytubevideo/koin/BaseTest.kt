package com.htk.ytubevideo.koin

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before

open class BaseTest {
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @OptIn(DelicateCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.shutdown()
    }
}
