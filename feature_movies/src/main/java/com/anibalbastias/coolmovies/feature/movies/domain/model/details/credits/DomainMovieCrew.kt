package com.anibalbastias.coolmovies.feature.movies.domain.model.details.credits

data class DomainMovieCrew(
    val gender: Int,
    val creditId: String,
    val name: String,
    val profilePath: String,
    val id: Int,
    val department: String,
    val job: String
)