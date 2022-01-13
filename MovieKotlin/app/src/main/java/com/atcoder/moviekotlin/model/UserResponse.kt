package com.atcoder.moviekotlin.model

data class UserResponse(
    val code: Int,
    val user: User,
    val error: Boolean,
    val message: String
)