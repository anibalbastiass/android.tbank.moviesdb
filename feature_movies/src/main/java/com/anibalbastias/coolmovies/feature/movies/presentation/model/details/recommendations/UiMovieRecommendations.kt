package com.anibalbastias.coolmovies.feature.movies.presentation.model.details.recommendations

data class UiMovieRecommendations(
	val page: Int,
	val totalPages: Int,
	val results: MutableList<UiMovieRecommendationsResults>,
	val totalResults: Int
)