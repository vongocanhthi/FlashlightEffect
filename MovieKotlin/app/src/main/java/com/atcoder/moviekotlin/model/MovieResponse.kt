package com.atcoder.moviekotlin.model

data class MovieResponse<T>(
    val code: Int,
    val data: T,
    val error: Boolean,
    val message: String,
    val paging: Paging
)

