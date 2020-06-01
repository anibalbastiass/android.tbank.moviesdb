package com.anibalbastias.coolmovies.feature.movies.domain.usecase

import com.anibalbastias.coolmovies.feature.movies.domain.repository.MoviesRepository

internal class GetMovieDetailsUseCase(
    private val moviesRepository: MoviesRepository
) {
    suspend fun execute(movieId: String, map: HashMap<String, String>) =
        moviesRepository.getMovieDetails(movieId, map)
}
