package com.anibalbastias.coolmovies.feature.movies.presentation.model.details.credits

data class UiMovieCast(
    val castId: Int = 0,
    val character: String = "",
    val gender: Int = 0,
    val creditId: String = "",
    val name: String = "",
    val profilePath: String = "",
    val id: Int = 0,
    val order: Int = 0
) {
    companion object {
        fun create() = UiMovieCast()
    }
}