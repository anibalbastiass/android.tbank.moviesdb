package com.anibalbastias.coolmovies.feature.movies.presentation.model

data class UiMovieItem(
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
) {
    companion object {
        private const val DEFAULT_EMPTY = ""
        private const val DEFAULT_LONG = 0
        private const val DEFAULT_DOUBLE = 0.0
        private const val DEFAULT_BOOLEAN = false

        fun create() = UiMovieItem(
            popularity = DEFAULT_DOUBLE,
            voteCount = DEFAULT_LONG.toLong(),
            video = DEFAULT_BOOLEAN,
            posterPath = DEFAULT_EMPTY,
            id = DEFAULT_LONG.toLong(),
            adult = DEFAULT_BOOLEAN,
            backDropPath = DEFAULT_EMPTY,
            originalLanguage = DEFAULT_EMPTY,
            originalTitle = DEFAULT_EMPTY,
            genreIds = arrayListOf(),
            title = DEFAULT_EMPTY,
            voteAverage = DEFAULT_DOUBLE,
            overview = DEFAULT_EMPTY,
            releaseDate = DEFAULT_EMPTY
        )
    }
}
