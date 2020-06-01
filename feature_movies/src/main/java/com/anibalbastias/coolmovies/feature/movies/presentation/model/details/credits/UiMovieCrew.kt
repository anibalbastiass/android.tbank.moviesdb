package com.anibalbastias.coolmovies.feature.movies.presentation.model.details.credits

data class UiMovieCrew(
    val gender: Int,
    val creditId: String,
    val name: String,
    val profilePath: String,
    val id: Int,
    val department: String,
    val job: String
)