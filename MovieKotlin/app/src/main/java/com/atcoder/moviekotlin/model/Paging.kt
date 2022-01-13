package com.atcoder.moviekotlin.model

data class Paging(
    val current_page: Int,
    val per_page: Int,
    val total_item: Int,
    val total_pages: Int
)