package com.anibalbastias.coolmovies.feature.movies.domain.repository

import com.anibalbastias.coolmovies.feature.movies.domain.model.configuration.DomainConfiguration
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.DomainMovieDetails
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.credits.DomainMovieCredits
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.recommendations.DomainMovieRecommendations
import com.anibalbastias.coolmovies.feature.movies.domain.model.list.DomainMovieItem

internal interface MoviesRepository {

    suspend fun getConfiguration(): DomainConfiguration?

    suspend fun discoverMovies(map: HashMap<String, String>): List<DomainMovieItem>?

    suspend fun getMovieDetails(movieId: String, map: HashMap<String, String>): DomainMovieDetails?

    suspend fun getMovieDetailsCredits(movieId: String): DomainMovieCredits?

    suspend fun getMovieDetailsRecommendations(movieId: String): DomainMovieRecommendations?

}
