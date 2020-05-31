package com.anibalbastias.coolmovies.feature.movies.domain.model

data class DomainMovieItem(
    val popularity: Double,
    val voteCount: Long,
    val video: Boolean,
    val posterPath: String,
    val id: Long,
    val adult: Boolean,
    val backDropPath: String,
    val originalLanguage: String,
    val originalTitle: String,
    val genreIds: List<Long>,
    val title: String,
    val voteAverage: Double,
    val overview: String,
    val releaseDate: String
)
