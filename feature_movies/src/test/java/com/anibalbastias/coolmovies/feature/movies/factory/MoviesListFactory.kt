package com.anibalbastias.coolmovies.feature.movies.factory

import com.anibalbastias.coolmovies.feature.movies.data.model.RemoteDiscoverMovies
import com.anibalbastias.coolmovies.feature.movies.data.model.list.RemoteMovieItem
import com.anibalbastias.coolmovies.feature.movies.domain.model.list.DomainMovieItem
import com.anibalbastias.coolmovies.library.testutils.foundation.RandomFactory.generateArrayLong
import com.anibalbastias.coolmovies.library.testutils.foundation.RandomFactory.generateBoolean
import com.anibalbastias.coolmovies.library.testutils.foundation.RandomFactory.generateDouble
import com.anibalbastias.coolmovies.library.testutils.foundation.RandomFactory.generateInt
import com.anibalbastias.coolmovies.library.testutils.foundation.RandomFactory.generateLong
import com.anibalbastias.coolmovies.library.testutils.foundation.RandomFactory.generateString

object MoviesListFactory {

    fun makeRemoteDiscoverMovies() = RemoteDiscoverMovies(
        page = generateInt(),
        totalPages = generateInt(),
        totalResults = generateInt(),
        results = (0..5).map {
            makeRemoteMoveItem()
        }
    )

    private fun makeRemoteMoveItem() = RemoteMovieItem(
        popularity = generateDouble(),
        voteCount = generateLong(),
        video = generateBoolean(),
        posterPath = generateString(),
        id = generateLong(),
        adult = generateBoolean(),
        backDropPath = generateString(),
        originalLanguage = generateString(),
        originalTitle = generateString(),
        genreIds = generateArrayLong(),
        title = generateString(),
        voteAverage = generateDouble(),
        overview = generateString(),
        releaseDate = generateString()
    )

    fun makeDomainMovieItem() = DomainMovieItem(
        popularity = generateDouble(),
        voteCount = generateLong(),
        video = generateBoolean(),
        posterPath = generateString(),
        id = generateLong(),
        adult = generateBoolean(),
        backDropPath = generateString(),
        originalLanguage = generateString(),
        originalTitle = generateString(),
        genreIds = generateArrayLong(),
        title = generateString(),
        voteAverage = generateDouble(),
        overview = generateString(),
        releaseDate = generateString()
    )

}