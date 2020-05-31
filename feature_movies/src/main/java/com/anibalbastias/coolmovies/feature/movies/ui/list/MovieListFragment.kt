package com.anibalbastias.coolmovies.feature.movies.ui.list

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.room.Room
import com.anibalbastias.coolmovies.app.CoolMoviesApplication
import com.anibalbastias.coolmovies.feature.movies.R
import com.anibalbastias.coolmovies.feature.movies.data.room.Constants
import com.anibalbastias.coolmovies.feature.movies.data.room.MoviesDatabase
import com.anibalbastias.coolmovies.feature.movies.ui.list.recyclerview.MovieAdapter
import com.anibalbastias.coolmovies.feature.movies.ui.list.recyclerview.GridAutofitLayoutManager
import com.anibalbastias.coolmovies.feature.movies.presentation.viewmodel.MovieListViewModel
import com.anibalbastias.coolmovies.feature.movies.presentation.viewstate.MovieListViewState
import com.anibalbastias.coolmovies.feature.movies.ui.MoviesNavigator
import com.anibalbastias.coolmovies.library.base.presentation.extension.observe
import com.anibalbastias.coolmovies.library.base.presentation.fragment.BaseContainerFragment
import com.pawegio.kandroid.visible
import kotlinx.android.synthetic.main.fragment_movie_list.*
import org.kodein.di.generic.instance

class MovieListFragment : BaseContainerFragment() {

    override val layoutResourceId = R.layout.fragment_movie_list
    private val viewModel: MovieListViewModel by instance()
    private val movieAdapter: MovieAdapter by instance()
    private val movieNavigator: MoviesNavigator by instance()

    private val stateObserver = Observer<MovieListViewState> {
        movieAdapter.movies = it.movies
        progressBar.visible = it.isLoading
        errorAnimation.visible = it.isError
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Room.databaseBuilder(
            CoolMoviesApplication.appContext,
            MoviesDatabase::class.java,
            Constants.DATABASE_NAME
        ).allowMainThreadQueries().build()

        val context = requireContext()

        movieAdapter.setOnDebouncedClickListener {
//            movieNavigator.navigateToAlbumDetails(it.artist, it.name, it.mbId)
        }

        recyclerView.apply {
            setHasFixedSize(true)
            val columnWidth = context.resources.getDimension(R.dimen.image_size).toInt()
            layoutManager =
                GridAutofitLayoutManager(
                    context,
                    columnWidth
                )
            adapter = movieAdapter
        }

        observe(viewModel.stateLiveData, stateObserver)
        viewModel.loadData()
    }
}
