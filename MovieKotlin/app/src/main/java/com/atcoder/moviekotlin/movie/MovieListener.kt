package com.atcoder.moviekotlin.movie

interface MovieListener {
    fun onLikeClick()
    fun onWatchClick(id:Int)
}