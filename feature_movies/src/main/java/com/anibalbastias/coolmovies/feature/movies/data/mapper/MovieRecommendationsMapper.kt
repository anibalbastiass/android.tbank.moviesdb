package com.anibalbastias.coolmovies.feature.movies.data.mapper

import com.anibalbastias.coolmovies.feature.movies.data.model.details.recommendations.RemoteMovieRecommendations
import com.anibalbastias.coolmovies.feature.movies.data.model.details.recommendations.RemoteMovieRecommendationsResults
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.recommendations.DomainMovieRecommendations
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.recommendations.DomainMovieRecommendationsResults

class MovieRecommendationsMapper {

    companion object {
        const val DEFAULT_STRING = ""
        const val DEFAULT_BOOLEAN = false
        const val DEFAULT_INT: Int = 0
        const val DEFAULT_DOUBLE: Double = 0.0
    }

    fun RemoteMovieRecommendations.fromRemoteToDomain() =
        DomainMovieRecommendations(
            page = page ?: DEFAULT_INT,
            totalPages = totalPages ?: DEFAULT_INT,
            results = results?.map { it?.fromRemoteToDomain()!! }!!,
            totalResults = totalResults ?: DEFAULT_INT
        )

    private fun RemoteMovieRecommendationsResults.fromRemoteToDomain() =
        DomainMovieRecommendationsResults(
            overview = overview ?: DEFAULT_STRING,
            originalLanguage = originalLanguage ?: DEFAULT_STRING,
            originalTitle = originalTitle ?: DEFAULT_STRING,
            video = video ?: DEFAULT_BOOLEAN,
            title = title ?: DEFAULT_STRING,
            genreIds = genreIds as List<Int>,
            posterPath = posterPath ?: DEFAULT_STRING,
            backdropPath = backdropPath ?: DEFAULT_STRING,
            releaseDate = releaseDate ?: DEFAULT_STRING,
            voteAverage = voteAverage ?: DEFAULT_DOUBLE,
            popularity = popularity ?: DEFAULT_DOUBLE,
            id = id ?: DEFAULT_INT,
            adult = adult ?: DEFAULT_BOOLEAN,
            voteCount = voteCount ?: DEFAULT_INT
        )

}