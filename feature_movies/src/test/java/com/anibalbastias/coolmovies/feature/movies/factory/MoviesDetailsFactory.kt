package com.anibalbastias.coolmovies.feature.movies.factory

import com.anibalbastias.coolmovies.feature.movies.data.mapper.MovieRecommendationsMapper
import com.anibalbastias.coolmovies.feature.movies.data.model.details.credits.RemoteMovieCast
import com.anibalbastias.coolmovies.feature.movies.data.model.details.credits.RemoteMovieCredits
import com.anibalbastias.coolmovies.feature.movies.data.model.details.credits.RemoteMovieCrew
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.DomainMovieDetails
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.credits.DomainMovieCast
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.credits.DomainMovieCredits
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.credits.DomainMovieCrew
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.recommendations.DomainMovieRecommendations
import com.anibalbastias.coolmovies.library.testutils.foundation.RandomFactory.generateBoolean
import com.anibalbastias.coolmovies.library.testutils.foundation.RandomFactory.generateDouble
import com.anibalbastias.coolmovies.library.testutils.foundation.RandomFactory.generateInt
import com.anibalbastias.coolmovies.library.testutils.foundation.RandomFactory.generateString

object MoviesDetailsFactory {

    fun makeRemoteMovieCredits() = RemoteMovieCredits(
        cast = (0..5).map { makeRemoteMovieCast() },
        id = generateInt(),
        crew = (0..5).map { makeRemoteMovieCrew() }
    )

    private fun makeRemoteMovieCast() = RemoteMovieCast(
        castId = generateInt(),
        character = generateString(),
        gender = generateInt(),
        creditId = generateString(),
        name = generateString(),
        profilePath = generateString(),
        id = generateInt(),
        order = generateInt()
    )

    private fun makeRemoteMovieCrew() = RemoteMovieCrew(
        gender = generateInt(),
        creditId = generateString(),
        name = generateString(),
        profilePath = generateString(),
        id = generateInt(),
        department = generateString(),
        job = generateString()
    )

    fun makeDomainMovieCredits() = DomainMovieCredits(
        cast = (0..5).map { makeDomainMovieCast() },
        id = generateInt(),
        crew = (0..5).map { makeDomainMovieCrew() }
    )

    private fun makeDomainMovieCast() = DomainMovieCast(
        castId = generateInt(),
        character = generateString(),
        gender = generateInt(),
        creditId = generateString(),
        name = generateString(),
        profilePath = generateString(),
        id = generateInt(),
        order = generateInt()
    )

    private fun makeDomainMovieCrew() = DomainMovieCrew(
        gender = generateInt(),
        creditId = generateString(),
        name = generateString(),
        profilePath = generateString(),
        id = generateInt(),
        department = generateString(),
        job = generateString()
    )

    fun makeDomainMovieDetails() = DomainMovieDetails(
        originalLanguage = generateString(),
        imdbId = generateString(),
        videos = null,
        video = generateBoolean(),
        title = generateString(),
        backdropPath = generateString(),
        revenue = generateInt(),
        genres = arrayListOf(),
        popularity = generateDouble(),
        productionCountries = arrayListOf(),
        id = generateInt(),
        voteCount = generateInt(),
        budget = generateInt(),
        overview = generateString(),
        images = null,
        originalTitle = generateString(),
        runtime = generateInt(),
        posterPath = generateString(),
        spokenLanguages = arrayListOf(),
        productionCompanies = arrayListOf(),
        releaseDate = generateString(),
        voteAverage = generateDouble(),
        belongsToCollection = null,
        tagLine = generateString(),
        adult = generateBoolean(),
        homepage = generateString(),
        status = generateString(),
        isFavorite = generateBoolean()
    )

    fun makeDomainMovieRecommendations() = DomainMovieRecommendations(
        page = generateInt(),
        totalPages = generateInt(),
        results = arrayListOf(),
        totalResults = generateInt()
    )
}