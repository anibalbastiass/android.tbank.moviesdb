package com.anibalbastias.coolmovies.feature.movies.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.anibalbastias.coolmovies.feature.movies.domain.model.configuration.DomainConfiguration
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

    private lateinit var uiConfiguration: DomainConfiguration
    var numPage: Int = 1

    override fun onLoadData() {
        getConfiguration()
    }

    override fun onReduceState(viewAction: MovieListAction) = when (viewAction) {
        is MovieListAction.MovieListLoadingSuccess -> state.copy(
            isLoading = false,
            isError = false,
            movies = with(uiDiscoverMoviesMapper) { viewAction.movies.map { it.fromDomainToUi(uiConfiguration) } }
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
                uiConfiguration = it
                getMovieList()
            }
        }
    }

    private fun getMovieList() {
        viewModelScope.launch {
            val map = hashMapOf<String, String>()
            getDiscoverMoviesUseCase.execute(numPage, map)?.also {
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

    fun postErrorAction() {
        sendAction(MovieListAction.MovieListLoadingFailure)
    }
}
