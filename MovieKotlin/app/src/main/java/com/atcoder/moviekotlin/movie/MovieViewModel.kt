package com.atcoder.moviekotlin.movie

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.atcoder.moviekotlin.api.APIService
import com.atcoder.moviekotlin.api.ClientInterface
import com.atcoder.moviekotlin.base.BaseViewModel
import com.atcoder.moviekotlin.model.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiConsumer
import io.reactivex.schedulers.Schedulers

class MovieViewModel(application: Application) : BaseViewModel(application) {
    private var client: ClientInterface = APIService.client
    private val movieListLiveData: MutableLiveData<List<Movie>> = MutableLiveData()

    fun init() {
        getMovieList()
    }

    private fun getMovieList() {
        addDisposable(
            client.getMovieList()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val movies: List<Movie> = it.data
                    movieListLiveData.value = movies
                }) {
                    Log.e("zzz", "getMovieList Error: " + it.message)
                }
        )
    }

    fun getMovieListLiveData(): LiveData<List<Movie>> {
        return movieListLiveData
    }

}