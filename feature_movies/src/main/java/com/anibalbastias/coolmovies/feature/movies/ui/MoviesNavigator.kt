package com.anibalbastias.coolmovies.feature.movies.ui

import com.anibalbastias.coolmovies.feature.movies.presentation.model.UiMovieItem
import com.anibalbastias.coolmovies.feature.movies.presentation.model.details.recommendations.UiMovieRecommendationsResults
import com.anibalbastias.coolmovies.feature.movies.presentation.detail.MovieDetailFragmentDirections
import com.anibalbastias.coolmovies.feature.movies.presentation.list.MovieListFragmentDirections
import com.anibalbastias.coolmovies.library.base.presentation.navigation.NavManager

class MoviesNavigator(private val navManager: NavManager) {

    fun navigateToMovieDetails(item: UiMovieItem) {
        val navDirections = MovieListFragmentDirections.actionMovieListToMovieDetails("${item.id}")
        navManager.navigate(navDirections)
    }

    fun navigateToRecommendedMovieDetails(item: UiMovieRecommendationsResults) {
        val navDirections = MovieDetailFragmentDirections.actionMovieDetailsToRecommendationDetails("${item.id}")
        navManager.navigate(navDirections)
    }

}