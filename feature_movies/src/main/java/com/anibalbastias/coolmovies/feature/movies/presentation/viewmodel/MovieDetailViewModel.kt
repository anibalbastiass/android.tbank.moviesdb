package com.anibalbastias.coolmovies.feature.movies.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.anibalbastias.coolmovies.feature.movies.domain.model.configuration.DomainConfiguration
import com.anibalbastias.coolmovies.feature.movies.domain.usecase.GetConfigurationUseCase
import com.anibalbastias.coolmovies.feature.movies.domain.usecase.GetMovieCreditsUseCase
import com.anibalbastias.coolmovies.feature.movies.domain.usecase.GetMovieDetailsUseCase
import com.anibalbastias.coolmovies.feature.movies.domain.usecase.GetMovieRecommendationsUseCase
import com.anibalbastias.coolmovies.feature.movies.presentation.action.MovieDetailsAction
import com.anibalbastias.coolmovies.feature.movies.presentation.mapper.UiMovieCreditsMapper
import com.anibalbastias.coolmovies.feature.movies.presentation.mapper.UiMovieDetailsMapper
import com.anibalbastias.coolmovies.feature.movies.presentation.mapper.UiMovieRecommendationsMapper
import com.anibalbastias.coolmovies.feature.movies.presentation.viewstate.MovieDetailsViewState
import com.anibalbastias.coolmovies.library.base.presentation.viewmodel.BaseViewModel
import kotlinx.coroutines.launch

internal class MovieDetailViewModel(
    private val uiMovieDetailsMapper: UiMovieDetailsMapper,
    private val uiMovieCreditsMapper: UiMovieCreditsMapper,
    private val uiMovieRecommendationsMapper: UiMovieRecommendationsMapper,
    private val getConfigurationUseCase: GetConfigurationUseCase,
    private val getMovieDetailsUseCase: GetMovieDetailsUseCase,
    private val getMovieCreditsUseCase: GetMovieCreditsUseCase,
    private val getMovieRecommendationsUseCase: GetMovieRecommendationsUseCase
) : BaseViewModel<MovieDetailsViewState, MovieDetailsAction>(
    MovieDetailsViewState()
) {

    private lateinit var uiConfiguration: DomainConfiguration
    lateinit var movieId: String

    override fun onLoadData() {
        getConfiguration()
    }

    override fun onReduceState(viewAction: MovieDetailsAction) = when (viewAction) {
        // Details
        is MovieDetailsAction.MovieDetailsLoadingSuccess -> state.copy(
            isLoading = false,
            isError = false,
            movieDetails = with(uiMovieDetailsMapper) {
                viewAction.movieDetails.fromDomainToUi(
                    uiConfiguration
                )
            }
        )
        MovieDetailsAction.MovieDetailsLoadingFailure -> state.copy(
            isLoading = false,
            isError = true
        )
        // Credits
        is MovieDetailsAction.MovieCreditsLoadingSuccess -> state.copy(
            isLoading = false,
            isError = false,
            movieCredits = with(uiMovieCreditsMapper) {
                viewAction.movieCredits.fromDomainToUi(
                    uiConfiguration
                )
            }
        )
        MovieDetailsAction.MovieCreditsLoadingFailure -> state.copy(
            isLoading = false,
            isError = true
        )

        // Recommendations
        is MovieDetailsAction.MovieRecommendationsLoadingSuccess -> state.copy(
            isLoading = false,
            isError = false,
            movieRecommendations = with(uiMovieRecommendationsMapper) {
                viewAction.movieRecommendations.fromDomainToUi(
                    uiConfiguration
                )
            }
        )
        MovieDetailsAction.MovieRecommendationsLoadingFailure -> state.copy(
            isLoading = false,
            isError = true
        )
    }

    private fun getConfiguration() {
        viewModelScope.launch {
            getConfigurationUseCase.execute()?.also {
                uiConfiguration = it
                getMovieDetails()
                getMovieCredits()
                getMovieRecommendations()
            }
        }
    }

    private fun getMovieDetails() {
        viewModelScope.launch {
            val map = hashMapOf<String, String>()
            getMovieDetailsUseCase.execute(movieId, map).also {
                if (it != null) {
                    sendAction(
                        MovieDetailsAction.MovieDetailsLoadingSuccess(
                            it
                        )
                    )
                } else {
                    sendAction(MovieDetailsAction.MovieDetailsLoadingFailure)
                }
            }
        }
    }

    private fun getMovieCredits() {
        viewModelScope.launch {
            getMovieCreditsUseCase.execute(movieId).also {
                if (it != null) {
                    sendAction(
                        MovieDetailsAction.MovieCreditsLoadingSuccess(
                            it
                        )
                    )
                } else {
                    sendAction(MovieDetailsAction.MovieCreditsLoadingFailure)
                }
            }
        }
    }

    private fun getMovieRecommendations() {
        viewModelScope.launch {
            getMovieRecommendationsUseCase.execute(movieId).also {
                if (it != null) {
                    sendAction(
                        MovieDetailsAction.MovieRecommendationsLoadingSuccess(
                            it
                        )
                    )
                } else {
                    sendAction(MovieDetailsAction.MovieRecommendationsLoadingFailure)
                }
            }
        }
    }
}
