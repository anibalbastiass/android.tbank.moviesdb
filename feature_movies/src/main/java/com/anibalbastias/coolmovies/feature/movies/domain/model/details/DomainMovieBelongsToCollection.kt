package com.anibalbastias.coolmovies.feature.movies.domain.model.details

data class DomainMovieBelongsToCollection(
    val backdropPath: String,
    val name: String,
    val id: Int,
    val posterPath: String
)