package com.anibalbastias.coolmovies.feature.movies.presentation.model.details.credits

data class UiMovieCredits(
	val cast: List<UiMovieCast>,
	val id: Int,
	val crew: List<UiMovieCrew>
)