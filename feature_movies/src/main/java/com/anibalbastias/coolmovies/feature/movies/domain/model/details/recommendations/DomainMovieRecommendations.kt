package com.anibalbastias.coolmovies.feature.movies.domain.model.details.recommendations

data class DomainMovieRecommendations(
	val page: Int,
	val totalPages: Int,
	val results: List<DomainMovieRecommendationsResults>,
	val totalResults: Int
)