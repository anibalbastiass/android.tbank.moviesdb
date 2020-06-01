package com.anibalbastias.coolmovies.feature.movies.presentation.model.details.credits

data class UiMovieCredits(
	val cast: MutableList<UiMovieCast>,
	val id: Int,
	val crew: MutableList<UiMovieCrew>
)