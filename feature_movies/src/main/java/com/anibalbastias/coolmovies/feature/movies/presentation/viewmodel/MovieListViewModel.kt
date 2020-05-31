package com.anibalbastias.coolmovies.feature.movies.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.anibalbastias.coolmovies.feature.movies.domain.usecase.GetConfigurationUseCase
import com.anibalbastias.coolmovies.feature.movies.domain.usecase.GetDiscoverMoviesUseCase
import com.anibalbastias.coolmovies.feature.movies.presentation.action.MovieListAction
import com.anibalbastias.coolmovies.feature.movies.presentation.mapper.UiDiscoverMoviesMapper
import com.anibalbastias.coolmovies.feature.movies.presentation.viewstate.MovieListViewState
import com.anibalbastias.coolmovies.library.base.presentation.viewmodel.BaseViewModel
import kotlinx.coroutines.launch

internal class MovieListViewModel(
    private val uiDiscoverMoviesMapper: UiDiscoverMoviesMapper,
    private val getConfigurationUseCase: GetConfigurationUseCase,
    private val getDiscoverMoviesUseCase: GetDiscoverMoviesUseCase
) : BaseViewModel<MovieListViewState, MovieListAction>(
    MovieListViewState()
) {

    override fun onLoadData() {
        getConfiguration()
    }

    override fun onReduceState(viewAction: MovieListAction) = when (viewAction) {
        is MovieListAction.MovieListLoadingSuccess -> state.copy(
            isLoading = false,
            isError = false,
            movies = with(uiDiscoverMoviesMapper) { viewAction.movies.map { it.fromDomainToUi() } }
        )
        is MovieListAction.MovieListLoadingFailure -> state.copy(
            isLoading = false,
            isError = true,
            movies = listOf()
        )
    }

    private fun getConfiguration() {
        viewModelScope.launch {
            getConfigurationUseCase.execute()?.also {
                getMovieList()
            }
        }
    }

    private fun getMovieList() {
        viewModelScope.launch {
            val map = hashMapOf<String, String>()
            getDiscoverMoviesUseCase.execute(map)?.also {
                if (it.isNotEmpty()) {
                    sendAction(
                        MovieListAction.MovieListLoadingSuccess(
                            it
                        )
                    )
                } else {
                    sendAction(MovieListAction.MovieListLoadingFailure)
                }
            }
        }
    }
}
