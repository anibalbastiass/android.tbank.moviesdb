package com.anibalbastias.coolmovies.feature.movies.domain.model.details.credits

data class DomainMovieCast(
    val castId: Int,
    val character: String,
    val gender: Int,
    val creditId: String,
    val name: String,
    val profilePath: String,
    val id: Int,
    val order: Int
)