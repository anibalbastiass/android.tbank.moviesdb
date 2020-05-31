package com.anibalbastias.coolmovies.feature.movies.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.anibalbastias.coolmovies.feature.movies.R
import com.anibalbastias.coolmovies.feature.movies.presentation.model.UiMovieItem
import com.anibalbastias.coolmovies.library.base.ui.adapter.base.BaseBindClickHandler
import com.anibalbastias.coolmovies.library.base.ui.adapter.base.BaseBindViewHolder
import com.anibalbastias.coolmovies.library.base.ui.adapter.customBase.BaseAdapter

internal class MovieAdapter : BaseAdapter<UiMovieItem>() {

    override var items: MutableList<UiMovieItem?> = arrayListOf()
    override var clickHandler: BaseBindClickHandler<UiMovieItem>? = null

    //region Unused methods
    override fun createHeaderViewHolder(parent: ViewGroup): RecyclerView.ViewHolder? = null
    override fun bindHeaderViewHolder(viewHolder: RecyclerView.ViewHolder) {}
    override fun bindFooterViewHolder(viewHolder: RecyclerView.ViewHolder) {}
    //endregion

    override fun createItemViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_movie_list_item, parent, false
        )
        return BaseBindViewHolder<UiMovieItem>(binding)
    }

    override fun createLoadingViewHolder(parent: ViewGroup): RecyclerView.ViewHolder? {
        val view2 = LayoutInflater.from(parent.context).inflate(
            R.layout.view_cell_paging_loader, parent, false
        )
        return PagingLoaderHolder(view2)
    }

    override fun bindItemViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val holder = viewHolder as BaseBindViewHolder<UiMovieItem>
        items[position]?.let {
            holder.bind(it, clickHandler)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when {
            isLastPosition(position) && isLoadingAdded -> LOADING_TYPE
            else -> ITEM_TYPE
        }
    }

    override fun addLoadingFooter() {
        isLoadingAdded = true
        add(UiMovieItem.create())
    }
}
    
    
    /*: RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {

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
}*/
