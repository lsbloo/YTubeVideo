package com.htk.ytubevideo.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.testing.TestLifecycleOwner
import kotlin.test.assertEquals

open class BaseUnitTest<BaseViewModel> {

    var viewModel = this as BaseViewModel

    private val lifecycle = TestLifecycleOwner()

    fun <UIAction> LiveData<UIAction>.asObserverTester(action: (UIAction) -> Unit) {
        this.observe(lifecycle) {
            action.invoke(it)
        }
    }

    fun <UIAction> LiveData<UIAction>.onChangedTest(action: (UIAction)) {
         this.observe(lifecycle, Observer {
            assertEquals(it, action)
        })
    }
}