package com.anibalbastias.coolmovies.feature.movies.domain.model.details.credits

data class DomainMovieCredits(
	val cast: List<DomainMovieCast>,
	val id: Int,
	val crew: List<DomainMovieCrew>
)