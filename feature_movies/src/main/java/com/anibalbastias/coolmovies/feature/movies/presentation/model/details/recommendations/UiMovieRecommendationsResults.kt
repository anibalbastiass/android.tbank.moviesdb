package com.anibalbastias.coolmovies.feature.movies.presentation.model.details.recommendations

data class UiMovieRecommendationsResults(
	val overview: String,
	val originalLanguage: String,
	val originalTitle: String,
	val video: Boolean,
	val title: String,
	val genreIds: List<Int>,
	val posterPath: String,
	val backdropPath: String,
	val releaseDate: String,
	val voteAverage: Double,
	val popularity: Double,
	val id: Int,
	val adult: Boolean,
	val voteCount: Int
)