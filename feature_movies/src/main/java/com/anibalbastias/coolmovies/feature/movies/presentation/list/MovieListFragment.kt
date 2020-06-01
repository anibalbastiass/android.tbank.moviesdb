package com.anibalbastias.coolmovies.feature.movies.presentation.list

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.anibalbastias.coolmovies.feature.movies.R
import com.anibalbastias.coolmovies.feature.movies.databinding.FragmentMovieListBinding
import com.anibalbastias.coolmovies.feature.movies.presentation.model.UiMovieItem
import com.anibalbastias.coolmovies.feature.movies.presentation.viewmodel.MovieListViewModel
import com.anibalbastias.coolmovies.feature.movies.presentation.viewstate.MovieListViewState
import com.anibalbastias.coolmovies.feature.movies.ui.MoviesNavigator
import com.anibalbastias.coolmovies.feature.movies.presentation.list.adapter.MovieAdapter
import com.anibalbastias.coolmovies.library.base.presentation.extension.observe
import com.anibalbastias.coolmovies.library.base.presentation.fragment.BaseContainerFragment
import com.anibalbastias.coolmovies.library.base.presentation.viewmodel.PaginationViewModel
import com.anibalbastias.coolmovies.library.base.ui.adapter.base.BaseBindClickHandler
import com.anibalbastias.coolmovies.library.base.ui.extension.*
import com.pawegio.kandroid.visible
import kotlinx.android.synthetic.main.fragment_movie_list.*
import org.kodein.di.generic.instance

class MovieListFragment : BaseContainerFragment() {

    override val layoutResourceId = R.layout.fragment_movie_list
    private val viewModel: MovieListViewModel by instance()
    private val paginationViewModel: PaginationViewModel<UiMovieItem> by instance()
    private val movieAdapter: MovieAdapter by instance()
    private val movieNavigator: MoviesNavigator by instance()

    private lateinit var binding: FragmentMovieListBinding

    private val stateObserver = Observer<MovieListViewState> {
        srlMovies.isRefreshing = it.isLoading
        progressBar.visible = it.isLoading
        errorAnimation.visible = it.isError

        if (!it.isLoading) {
            setPagination(it.movies)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.bind<ViewDataBinding>(view) as FragmentMovieListBinding
        binding.lifecycleOwner = this

        val context = requireContext()

        movieAdapter.clickHandler = object : BaseBindClickHandler<UiMovieItem> {
            override fun onClickView(view: View, item: UiMovieItem) {
                movieNavigator.navigateToMovieDetails(item)
            }
        }

        tbMovies.apply {
            applyFontForToolbarTitle(requireActivity())
            setNoArrowUpToolbar(requireActivity())
        }

        rvMovies.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = movieAdapter
            runLayoutAnimation()
        }

        observe(viewModel.stateLiveData, stateObserver)

        viewModel.stateLiveData.value?.movies?.let {
            progressBar.visible = false
            errorAnimation.visible = false
            setPagination(it)
        } ?: viewModel.loadData()

        srlMovies.initSwipe {
            paginationViewModel.run {
                offset.set(firstPage)
                viewModel.numPage = offset.get()
                viewModel.loadData()
            }
        }
    }

    private fun setPagination(movies: List<UiMovieItem>) {
        paginationViewModel.pageSize = movies.size

        paginationViewModel.setPagination(
            adapter = movieAdapter,
            items = movies as ArrayList<UiMovieItem>,
            bodyHasItems = { items ->
                if (items?.isNotEmpty() == true) {
                    movieAdapter.items = (items as? MutableList<UiMovieItem?>)!!
                    setAdapterByData()
                } else {
                    // Show Empty View
                    paginationViewModel.isEmpty.set(true)
                }
            }, bodyNoItems = { items ->
                movieAdapter.items = (items as? MutableList<UiMovieItem?>)!!
                setAdapterByData()
                // Show Empty View
                paginationViewModel.isEmpty.set(true)
            })
    }

    private fun setAdapterByData() {
        context?.let {
            binding.rvMovies.let { rv ->
                paginationViewModel.run {
                    rv.paginationForRecyclerScroll(
                        itemPosition = itemPosition,
                        lastPosition = lastPosition,
                        offset = offset,
                        listSize = movieAdapter.items.size,
                        pageSize = pageSize,
                        isLoadingMorePages = isLoadingMorePages
                    ) {
                        viewModel.numPage = offset.get()
                        viewModel.loadData()
                    }
                    rv.scrollToPosition(itemPosition.get())
                }
                rv.runLayoutAnimation()
            }
        }
    }
}
