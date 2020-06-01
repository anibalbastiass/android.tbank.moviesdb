package com.anibalbastias.coolmovies.feature.movies.presentation.action

import com.anibalbastias.coolmovies.feature.movies.domain.model.details.DomainMovieDetails
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.credits.DomainMovieCredits
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.recommendations.DomainMovieRecommendations
import com.anibalbastias.coolmovies.feature.movies.domain.model.list.DomainMovieItem
import com.anibalbastias.coolmovies.library.base.presentation.viewmodel.BaseAction

sealed class MovieDetailsAction : BaseAction {

    class MovieDetailsLoadingSuccess(val movieDetails: DomainMovieDetails) : MovieDetailsAction()
    object MovieDetailsLoadingFailure : MovieDetailsAction()

    class MovieCreditsLoadingSuccess(val movieCredits: DomainMovieCredits) : MovieDetailsAction()
    object MovieCreditsLoadingFailure : MovieDetailsAction()

    class MovieRecommendationsLoadingSuccess(val movieRecommendations: DomainMovieRecommendations) :
        MovieDetailsAction()

    object MovieRecommendationsLoadingFailure : MovieDetailsAction()
}