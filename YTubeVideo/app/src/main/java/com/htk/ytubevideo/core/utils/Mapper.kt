package com.htk.ytubevideo.core.utils

interface Mapper<S,T> {
    fun map(source: S): T
}