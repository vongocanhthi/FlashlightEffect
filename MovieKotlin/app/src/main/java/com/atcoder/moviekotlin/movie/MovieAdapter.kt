package com.atcoder.moviekotlin.movie

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atcoder.moviekotlin.R
import com.atcoder.moviekotlin.databinding.ItemMovieBinding
import com.atcoder.moviekotlin.model.Movie
import com.bumptech.glide.Glide

class MovieAdapter(diffCallback: DiffUtil.ItemCallback<Movie>, private val context: Context) :
    ListAdapter<Movie, MovieAdapter.MovieViewHolder>(diffCallback) {

    private lateinit var movieListener: MovieListener

    fun setMovieListener(movieListener: MovieListener) {
        this.movieListener = movieListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            ItemMovieBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MovieViewHolder(private var binding: ItemMovieBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.movie = movie

            initListener(movie)

            if (binding.txtLike.text.equals("Thích")) {
                binding.imgLike.setImageResource(R.drawable.ic_like)
                binding.txtLike.setTextColor(context.resources.getColor(R.color.white))
            } else {
                binding.imgLike.setImageResource(R.drawable.ic_like_orange)
                binding.txtLike.setTextColor(context.resources.getColor(R.color.orange_movie))
            }

            val title = movie.title.split("/")
            if (title.size == 2) {
                binding.txtTitle1.text = title[0].trim()
                binding.txtTitle2.text = title[1].trim()
            } else {
                binding.txtTitle1.text = title[0].trim()
                binding.txtTitle2.text = title[0].trim()
            }

            Glide.with(context)
                .load(movie.image)
                .into(binding.imgImage)

        }

        private fun initListener(movie: Movie) {
            binding.layoutLike.setOnClickListener({
                movieListener.onLikeClick()

                if (binding.txtLike.text.equals("Thích")) {
                    binding.imgLike.setImageResource(R.drawable.ic_like_orange)
                    binding.txtLike.text = "Đã thích"
                    binding.txtLike.setTextColor(context.resources.getColor(R.color.orange_movie))
                } else {
                    binding.imgLike.setImageResource(R.drawable.ic_like)
                    binding.txtLike.text = "Thích"
                    binding.txtLike.setTextColor(context.resources.getColor(R.color.white))

                }
            })

            binding.btnWatch.setOnClickListener({
                movieListener.onWatchClick(movie.id)
            })

        }

    }
}