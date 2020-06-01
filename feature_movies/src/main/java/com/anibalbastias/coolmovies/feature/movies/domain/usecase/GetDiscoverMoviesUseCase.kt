package com.anibalbastias.coolmovies.feature.movies.domain.usecase

import com.anibalbastias.coolmovies.feature.movies.domain.repository.MoviesRepository

internal class GetDiscoverMoviesUseCase(
    private val moviesRepository: MoviesRepository
) {
    suspend fun execute(page: Int, map: HashMap<String, String>) = moviesRepository.discoverMovies(page, map)
}
