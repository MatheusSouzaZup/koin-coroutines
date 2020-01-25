package com.example.koincorountines.ui.movies

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.koincorountines.R
import com.example.koincorountines.databinding.ItemMovieBinding
import com.example.koincorountines.model.Movie

class MovieAdapter(private val movieList: List<Movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_movie,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.onBind(movieList[position])
    }

    inner class MovieViewHolder(
        itemView: View,
        private val bind: ItemMovieBinding = DataBindingUtil.bind(itemView)!!
    ) : RecyclerView.ViewHolder(itemView) {
        fun onBind(movie: Movie) {
            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w342${movie.posterPath}")
//                .error(ContextCompat.getDrawable(WMApplication.getAppContext(), R.drawable.grey_logo))
//                .placeholder(ContextCompat.getDrawable(WMApplication.getAppContext(), R.drawable.grey_logo))
//                .apply(RequestOptions.circleCropTransform())
                .into(bind.ivPoster)
        }
    }
}