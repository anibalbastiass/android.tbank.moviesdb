package com.anibalbastias.coolmovies.feature.movies.presentation.model.details.credits

data class UiMovieCast(
    val castId: Int,
    val character: String,
    val gender: Int,
    val creditId: String,
    val name: String,
    val profilePath: String,
    val id: Int,
    val order: Int
)