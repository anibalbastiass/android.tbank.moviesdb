package com.anibalbastias.coolmovies.feature.movies.presentation.mapper

import com.anibalbastias.coolmovies.feature.movies.domain.model.configuration.DomainConfiguration
import com.anibalbastias.coolmovies.feature.movies.domain.model.list.DomainMovieItem
import com.anibalbastias.coolmovies.feature.movies.presentation.model.UiMovieItem
import com.anibalbastias.coolmovies.library.base.presentation.extension.formatDate

class UiDiscoverMoviesMapper {

    fun DomainMovieItem.fromDomainToUi(config: DomainConfiguration) = UiMovieItem(
        popularity = popularity,
        voteCount = voteCount,
        video = video,
        posterPath = config.images.run { "$secureBaseUrl${posterSizes[3].trim()}$posterPath" },
        id = id,
        adult = adult,
        backDropPath = config.images.run { "$secureBaseUrl${posterSizes[4].trim()}$posterPath" },
        originalLanguage = originalLanguage,
        originalTitle = originalTitle,
        genreIds = genreIds,
        title = title,
        voteAverage = voteAverage,
        overview = overview,
        releaseDate = releaseDate.formatDate()
    )

}