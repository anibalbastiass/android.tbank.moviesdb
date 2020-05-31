package com.anibalbastias.coolmovies.feature.movies.ui.list.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.RoundedCornersTransformation
import com.anibalbastias.coolmovies.feature.movies.R
import com.anibalbastias.coolmovies.feature.movies.presentation.model.UiMovieItem
import com.anibalbastias.coolmovies.library.base.delegate.observer
import com.anibalbastias.coolmovies.library.base.presentation.extension.setOnDebouncedClickListener
import com.pawegio.kandroid.hide
import com.pawegio.kandroid.show
import kotlinx.android.synthetic.main.fragment_movie_list_item.view.*

internal class MovieAdapter : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

    var movies: List<UiMovieItem> by observer(listOf()) {
        notifyDataSetChanged()
    }

    private var onDebouncedClickListener: ((movie: UiMovieItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_movie_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    fun setOnDebouncedClickListener(listener: (album: UiMovieItem) -> Unit) {
        this.onDebouncedClickListener = listener
    }

    internal inner class MyViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private var url by observer<String?>(null) {
            itemView.coverErrorImageView.hide()

            if (it == null) {
                setDefaultImage()
            } else {
                itemView.coverImageView.load(it) {
                    crossfade(true)
                    error(R.drawable.ic_image)
                    transformations(RoundedCornersTransformation(10F))
                }
            }
        }

        fun bind(movie: UiMovieItem) {
            itemView.setOnDebouncedClickListener { onDebouncedClickListener?.invoke(movie) }
            url = "https://image.tmdb.org/t/p/w342" + movie.posterPath
        }

        private fun setDefaultImage() {
            itemView.coverErrorImageView.show()
        }
    }
}
