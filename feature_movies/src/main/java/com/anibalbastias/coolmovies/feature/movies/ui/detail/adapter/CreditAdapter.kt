package com.anibalbastias.coolmovies.feature.movies.ui.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.anibalbastias.coolmovies.feature.movies.R
import com.anibalbastias.coolmovies.feature.movies.presentation.model.details.credits.UiMovieCast
import com.anibalbastias.coolmovies.library.base.ui.adapter.base.BaseBindClickHandler
import com.anibalbastias.coolmovies.library.base.ui.adapter.base.BaseBindViewHolder
import com.anibalbastias.coolmovies.library.base.ui.adapter.customBase.BaseAdapter

internal class CreditAdapter : BaseAdapter<UiMovieCast>() {

    override var items: MutableList<UiMovieCast?> = arrayListOf()
    override var clickHandler: BaseBindClickHandler<UiMovieCast>? = null

    //region Unused methods
    override fun createHeaderViewHolder(parent: ViewGroup): RecyclerView.ViewHolder? = null
    override fun bindHeaderViewHolder(viewHolder: RecyclerView.ViewHolder) {}
    override fun bindFooterViewHolder(viewHolder: RecyclerView.ViewHolder) {}
    //endregion

    override fun createItemViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_movie_credit_item, parent, false
        )
        return BaseBindViewHolder<UiMovieCast>(binding)
    }

    override fun createLoadingViewHolder(parent: ViewGroup): RecyclerView.ViewHolder? {
        val view2 = LayoutInflater.from(parent.context).inflate(
            R.layout.view_cell_paging_loader, parent, false
        )
        return PagingLoaderHolder(view2)
    }

    override fun bindItemViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val holder = viewHolder as BaseBindViewHolder<UiMovieCast>
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
        add(UiMovieCast.create())
    }
}
