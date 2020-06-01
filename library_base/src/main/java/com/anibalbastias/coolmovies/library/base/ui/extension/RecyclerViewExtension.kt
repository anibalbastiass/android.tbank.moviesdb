package com.anibalbastias.coolmovies.library.base.ui.extension

import android.view.animation.AnimationUtils
import androidx.databinding.ObservableInt
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anibalbastias.coolmovies.library.base.R
import java.util.concurrent.atomic.AtomicBoolean

fun RecyclerView.runLayoutAnimation() {
    layoutAnimation = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down)
    adapter?.notifyDataSetChanged()
    scheduleLayoutAnimation()
}

fun RecyclerView.paginationForRecyclerScroll(
    itemPosition: ObservableInt,
    lastPosition: ObservableInt,
    offset: ObservableInt,
    listSize: Int,
    pageSize: Int,
    isLoadingMorePages: AtomicBoolean,
    bodyLoadMore: (() -> Unit)?
) {
    addOnScrollListener(object :
        RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)

            // Set Item position
            itemPosition.set((layoutManager as GridLayoutManager).findFirstVisibleItemPosition())

            // Refresh Offset and add pagination
            val visibleItemCount = layoutManager?.childCount
            val totalItemCount = layoutManager?.itemCount
            val firstVisibleItemPosition =
                (layoutManager as GridLayoutManager).findFirstVisibleItemPosition()

            if (!isLoadingMorePages.get()) {
                if (visibleItemCount!! + firstVisibleItemPosition >= totalItemCount!! && firstVisibleItemPosition >= 0) {
                    lastPosition.set(listSize)

                    if (lastPosition.get() >= pageSize) {
                        isLoadingMorePages.set(true)
                        offset.set(offset.get() + 1)
                        bodyLoadMore?.invoke()
                    }
                }
            }
        }
    })
    scrollToPosition(itemPosition.get())
}