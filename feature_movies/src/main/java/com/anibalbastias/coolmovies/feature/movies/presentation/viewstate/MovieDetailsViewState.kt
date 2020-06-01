package com.anibalbastias.coolmovies.feature.movies.presentation.viewstate

import com.anibalbastias.coolmovies.feature.movies.presentation.model.details.UiMovieDetails
import com.anibalbastias.coolmovies.feature.movies.presentation.model.details.credits.UiMovieCredits
import com.anibalbastias.coolmovies.feature.movies.presentation.model.details.recommendations.UiMovieRecommendations
import com.anibalbastias.coolmovies.library.base.presentation.viewmodel.BaseViewState

data class MovieDetailsViewState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val movieDetails: UiMovieDetails? = null,
    val movieCredits: UiMovieCredits? = null,
    val movieRecommendations: UiMovieRecommendations? = null
) : BaseViewState