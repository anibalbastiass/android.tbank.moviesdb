package com.anibalbastias.coolmovies.feature.movies.data.mapper

import com.anibalbastias.coolmovies.feature.movies.data.model.movie.RemoteMovieItem
import com.anibalbastias.coolmovies.feature.movies.domain.model.DomainMovieItem

class DiscoverMoviesMapper {

    fun RemoteMovieItem.fromRemoteToDomain() = DomainMovieItem(
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