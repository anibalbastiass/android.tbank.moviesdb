package com.anibalbastias.coolmovies.feature.movies.presentation.mapper

import com.anibalbastias.coolmovies.feature.movies.domain.model.configuration.DomainConfiguration
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.credits.DomainMovieCast
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.credits.DomainMovieCredits
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.credits.DomainMovieCrew
import com.anibalbastias.coolmovies.feature.movies.presentation.model.details.credits.UiMovieCast
import com.anibalbastias.coolmovies.feature.movies.presentation.model.details.credits.UiMovieCredits
import com.anibalbastias.coolmovies.feature.movies.presentation.model.details.credits.UiMovieCrew


class UiMovieCreditsMapper {

    private lateinit var config: DomainConfiguration

    fun DomainMovieCredits.fromDomainToUi(uiConfiguration: DomainConfiguration): UiMovieCredits {
        this@UiMovieCreditsMapper.config = uiConfiguration
        return UiMovieCredits(
            cast = cast.map { it.fromDomainToUi() },
            id = id,
            crew = crew.map { it.fromDomainToUi() }
        )
    }

    private fun DomainMovieCast.fromDomainToUi() = UiMovieCast(
        castId = castId,
        character = character,
        gender = gender,
        creditId = creditId,
        name = name,
        profilePath = config.images.run {
            "$secureBaseUrl${profileSizes.first().trim()}$profilePath"
        },
        id = id,
        order = order
    )

    private fun DomainMovieCrew.fromDomainToUi() = UiMovieCrew(
        gender = gender,
        creditId = creditId,
        name = name,
        profilePath = config.images.run {
            "$secureBaseUrl${profileSizes.first().trim()}$profilePath"
        },
        id = id,
        department = department,
        job = job
    )
}