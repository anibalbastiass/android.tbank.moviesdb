package com.anibalbastias.coolmovies.feature.movies.ui.list

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableBoolean
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.anibalbastias.coolmovies.feature.movies.R
import com.anibalbastias.coolmovies.feature.movies.databinding.FragmentMovieListBinding
import com.anibalbastias.coolmovies.feature.movies.presentation.model.UiMovieItem
import com.anibalbastias.coolmovies.feature.movies.presentation.viewmodel.MovieListViewModel
import com.anibalbastias.coolmovies.feature.movies.presentation.viewstate.MovieListViewState
import com.anibalbastias.coolmovies.feature.movies.ui.MoviesNavigator
import com.anibalbastias.coolmovies.feature.movies.ui.list.adapter.MovieAdapter
import com.anibalbastias.coolmovies.library.base.presentation.extension.observe
import com.anibalbastias.coolmovies.library.base.presentation.fragment.BaseContainerFragment
import com.anibalbastias.coolmovies.library.base.ui.adapter.base.BaseBindClickHandler
import com.anibalbastias.coolmovies.library.base.ui.extension.applyFontForToolbarTitle
import com.anibalbastias.coolmovies.library.base.ui.extension.initSwipe
import com.anibalbastias.coolmovies.library.base.ui.extension.runLayoutAnimation
import com.anibalbastias.coolmovies.library.base.ui.extension.setNoArrowUpToolbar
import com.pawegio.kandroid.visible
import kotlinx.android.synthetic.main.fragment_movie_list.*
import org.kodein.di.generic.instance

class MovieListFragment : BaseContainerFragment() {

    override val layoutResourceId = R.layout.fragment_movie_list
    private val viewModel: MovieListViewModel by instance()
    private val movieAdapter: MovieAdapter by instance()
    private val movieNavigator: MoviesNavigator by instance()

    private lateinit var binding: FragmentMovieListBinding

    private val stateObserver = Observer<MovieListViewState> {
        movieAdapter.items = it.movies.toMutableList()
        movieAdapter.notifyDataSetChanged()

        srlMovies.isRefreshing = it.isLoading
        progressBar.visible = it.isLoading
        errorAnimation.visible = it.isError
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
        viewModel.loadData()

        srlMovies.initSwipe {
            viewModel.loadData()
        }
    }
}
