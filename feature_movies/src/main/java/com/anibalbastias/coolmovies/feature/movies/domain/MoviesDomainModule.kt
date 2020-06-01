package com.anibalbastias.coolmovies.feature.movies.domain

import com.anibalbastias.coolmovies.feature.movies.MODULE_NAME
import com.anibalbastias.coolmovies.feature.movies.domain.database.DatabaseRepositoryImpl
import com.anibalbastias.coolmovies.feature.movies.domain.mapper.BdConfigurationMapper
import com.anibalbastias.coolmovies.feature.movies.domain.repository.DatabaseRepository
import com.anibalbastias.coolmovies.feature.movies.domain.usecase.*
import com.anibalbastias.coolmovies.feature.movies.domain.usecase.GetConfigurationUseCase
import com.anibalbastias.coolmovies.feature.movies.domain.usecase.GetDiscoverMoviesUseCase
import com.anibalbastias.coolmovies.feature.movies.domain.usecase.GetMovieCreditsUseCase
import com.anibalbastias.coolmovies.feature.movies.domain.usecase.GetMovieDetailsUseCase
import com.anibalbastias.coolmovies.feature.movies.domain.usecase.GetMovieRecommendationsUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

internal val domainModule = Kodein.Module("${MODULE_NAME}DomainModule") {

    bind<DatabaseRepository>() with singleton {
        DatabaseRepositoryImpl(
            instance(),
            instance()
        )
    }

    bind() from singleton { BdConfigurationMapper() }

    bind() from singleton { GetConfigurationUseCase(instance()) }

    bind() from singleton { GetDiscoverMoviesUseCase(instance()) }

    bind() from singleton { GetMovieDetailsUseCase(instance()) }

    bind() from singleton { GetMovieCreditsUseCase(instance()) }

    bind() from singleton { GetMovieRecommendationsUseCase(instance()) }

}
