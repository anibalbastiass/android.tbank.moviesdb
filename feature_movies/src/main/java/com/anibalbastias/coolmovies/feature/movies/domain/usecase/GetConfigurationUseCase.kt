package com.anibalbastias.coolmovies.feature.movies.domain.usecase

import com.anibalbastias.coolmovies.feature.movies.domain.model.DomainConfiguration
import com.anibalbastias.coolmovies.feature.movies.domain.repository.MoviesRepository

internal class GetConfigurationUseCase(
    private val moviesRepository: MoviesRepository
) {
    suspend fun execute(): DomainConfiguration? = moviesRepository.getConfiguration()
}
