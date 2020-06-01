package com.anibalbastias.coolmovies.feature.movies.data.mapper

import com.anibalbastias.coolmovies.feature.movies.data.model.details.credits.RemoteMovieCast
import com.anibalbastias.coolmovies.feature.movies.data.model.details.credits.RemoteMovieCredits
import com.anibalbastias.coolmovies.feature.movies.data.model.details.credits.RemoteMovieCrew
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.credits.DomainMovieCast
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.credits.DomainMovieCredits
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.credits.DomainMovieCrew

class MovieCreditsMapper {

    companion object {
        const val DEFAULT_STRING: String = ""
        const val DEFAULT_INT: Int = 0
    }

    fun RemoteMovieCredits.fromRemoteToDomain() =
        DomainMovieCredits(
            cast = cast?.map { it?.fromRemoteToDomain()!! }!!,
            id = id ?: DEFAULT_INT,
            crew = crew?.map { it?.fromRemoteToDomain()!! }!!
        )

    private fun RemoteMovieCast.fromRemoteToDomain() = DomainMovieCast(
        castId = castId ?: DEFAULT_INT,
        character = character ?: DEFAULT_STRING,
        gender = gender ?: DEFAULT_INT,
        creditId = creditId ?: DEFAULT_STRING,
        name = name ?: DEFAULT_STRING,
        profilePath = profilePath ?: DEFAULT_STRING,
        id = id ?: DEFAULT_INT,
        order = order ?: DEFAULT_INT
    )

    private fun RemoteMovieCrew.fromRemoteToDomain() = DomainMovieCrew(
        gender = gender ?: DEFAULT_INT,
        creditId = creditId ?: DEFAULT_STRING,
        name = name ?: DEFAULT_STRING,
        profilePath = profilePath ?: DEFAULT_STRING,
        id = id ?: DEFAULT_INT,
        department = department ?: DEFAULT_STRING,
        job = job ?: DEFAULT_STRING
    )
}