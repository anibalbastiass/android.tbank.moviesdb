package com.anibalbastias.coolmovies.feature.movies.presentation.mapper

import com.anibalbastias.coolmovies.feature.movies.domain.model.configuration.DomainConfiguration
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.recommendations.DomainMovieRecommendations
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.recommendations.DomainMovieRecommendationsResults
import com.anibalbastias.coolmovies.feature.movies.presentation.model.details.recommendations.UiMovieRecommendations
import com.anibalbastias.coolmovies.feature.movies.presentation.model.details.recommendations.UiMovieRecommendationsResults
import com.anibalbastias.coolmovies.library.base.presentation.extension.formatDate

class UiMovieRecommendationsMapper {

    private lateinit var config: DomainConfiguration

    fun DomainMovieRecommendations.fromDomainToUi(uiConfiguration: DomainConfiguration): UiMovieRecommendations {
        this@UiMovieRecommendationsMapper.config = uiConfiguration
        return UiMovieRecommendations(
            page = page,
            totalPages = totalPages,
            results = results.map { it.fromDomainToUi() } as MutableList<UiMovieRecommendationsResults>,
            totalResults = totalResults
        )
    }

    private fun DomainMovieRecommendationsResults.fromDomainToUi() =
        UiMovieRecommendationsResults(
            overview = overview,
            originalLanguage = originalLanguage,
            originalTitle = originalTitle,
            video = video,
            title = title,
            genreIds = genreIds,
            posterPath = config.images.run {
                "$secureBaseUrl${posterSizes.last().trim()}$posterPath"
            },
            backdropPath = config.images.run {
                "$secureBaseUrl${backDropSizes.last().trim()}$backdropPath"
            },
            releaseDate = releaseDate.formatDate(),
            voteAverage = voteAverage,
            popularity = popularity,
            id = id,
            adult = adult,
            voteCount = voteCount
        )

}