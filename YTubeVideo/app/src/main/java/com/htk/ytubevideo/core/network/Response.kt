package com.htk.ytubevideo.core.network

sealed class Response<out T> {

    class Success<T>() {
        var data: T? = null
    }

    class Failure<T>() {
        var failure: T? = null
    }

    class Error<T>() {
        var error: T? = null
    }
}