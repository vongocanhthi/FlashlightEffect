package com.atcoder.moviekotlin.detail

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.atcoder.moviekotlin.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailBinding
    private lateinit var viewModel: MovieDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[MovieDetailViewModel::class.java]

        initControl()
        initListener()
    }

    private fun initControl() {
        var id: Int = intent.getIntExtra("id", 0)
        Log.d("zzz", "initControl: "+id)
    }

    private fun initListener() {

    }
}