package com.atcoder.moviekotlin.movie

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.atcoder.moviekotlin.base.BaseActivity
import com.atcoder.moviekotlin.databinding.ActivityMovieBinding
import com.atcoder.moviekotlin.detail.MovieDetailActivity
import com.atcoder.moviekotlin.listener.OnClickListener
import com.atcoder.moviekotlin.model.Movie
import com.atcoder.moviekotlin.util.DiffCallBack

class MovieActivity : BaseActivity(), MovieListener {
    private lateinit var binding: ActivityMovieBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]

        initControl()
        initListener()
    }

    private fun initControl() {
        binding.rcvMovie.apply {
            itemAnimator = null
            movieAdapter = MovieAdapter(DiffCallBack(), this@MovieActivity)
            adapter = movieAdapter
        }
    }

    private fun initListener() {
        movieAdapter.setMovieListener(this)
        viewModel.init()
        viewModel.getMovieListLiveData().observe(this, {
            movieAdapter.submitList(it)
        })
    }

    override fun onLikeClick() {

    }

    override fun onWatchClick(id: Int) {
//        val bundle = Bundle()
//        bundle.putInt("id", id)

        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }

}