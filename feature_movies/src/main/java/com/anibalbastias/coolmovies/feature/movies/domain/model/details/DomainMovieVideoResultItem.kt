package com.anibalbastias.coolmovies.feature.movies.domain.model.details

data class DomainMovieVideoResultItem(
	val site: String,
	val size: Int,
	val iso31661: String,
	val name: String,
	val id: String,
	val type: String,
	val iso6391: String,
	val key: String
)