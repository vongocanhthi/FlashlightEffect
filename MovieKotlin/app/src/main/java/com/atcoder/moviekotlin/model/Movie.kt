package com.atcoder.moviekotlin.model

import com.google.gson.annotations.SerializedName

data class Movie(
//    @SerializedName("actor")
    val actor: String,
    val category: String,
    val created_at: String,
    val description: String,
    val director: String,
    val duration: String,
    val id: Int,
    val image: String,
    val link: String,
    val manufacturer: String,
    val title: String,
    val type: String,
    val updated_at: String,
    val views: Int,
    val year: String
)