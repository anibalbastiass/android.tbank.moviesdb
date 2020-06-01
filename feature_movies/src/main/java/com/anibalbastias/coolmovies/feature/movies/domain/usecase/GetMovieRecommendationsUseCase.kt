package com.anibalbastias.coolmovies.feature.movies.domain.usecase

import com.anibalbastias.coolmovies.feature.movies.domain.repository.MoviesRepository

internal class GetMovieRecommendationsUseCase(
    private val moviesRepository: MoviesRepository
) {
    suspend fun execute(movieId: String) =
        moviesRepository.getMovieDetailsRecommendations(movieId)
}
