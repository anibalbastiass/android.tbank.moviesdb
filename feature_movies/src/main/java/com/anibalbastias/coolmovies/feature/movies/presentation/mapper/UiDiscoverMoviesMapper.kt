package com.anibalbastias.coolmovies.feature.movies.presentation.mapper

import com.anibalbastias.coolmovies.feature.movies.domain.model.DomainMovieItem
import com.anibalbastias.coolmovies.feature.movies.presentation.model.UiMovieItem

class UiDiscoverMoviesMapper {

    fun DomainMovieItem.fromDomainToUi() = UiMovieItem(
        popularity = popularity,
        voteCount = voteCount,
        video = video,
        posterPath = posterPath,
        id = id,
        adult = adult,
        backDropPath = backDropPath,
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        genreIds = genreIds,
        title = title,
        voteAverage = voteAverage,
        overview = overview,
        releaseDate = releaseDate
    )

}