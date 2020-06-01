package com.anibalbastias.coolmovies.feature.movies.data.repository

import com.anibalbastias.coolmovies.feature.movies.data.mapper.*
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.APPEND_TO_RESPONSE
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.EN_US
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.IMAGES_VIDEOS
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.LANGUAGE
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.PAGE
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.MoviesRetrofitService
import com.anibalbastias.coolmovies.feature.movies.domain.model.configuration.DomainConfiguration
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.DomainMovieDetails
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.credits.DomainMovieCredits
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.recommendations.DomainMovieRecommendations
import com.anibalbastias.coolmovies.feature.movies.domain.model.list.DomainMovieItem
import com.anibalbastias.coolmovies.feature.movies.domain.repository.DatabaseRepository
import com.anibalbastias.coolmovies.feature.movies.domain.repository.MoviesRepository

internal class RemoteRepositoryImpl(
    private val moviesRetrofitService: MoviesRetrofitService,
    private val configurationMapper: ConfigurationMapper,
    private val discoverMoviesMapper: DiscoverMoviesMapper,
    private val movieDetailsMapper: MovieDetailsMapper,
    private val movieCreditsMapper: MovieCreditsMapper,
    private val movieRecommendationsMapper: MovieRecommendationsMapper,
    private val databaseRepository: DatabaseRepository
) : MoviesRepository {

    override suspend fun getConfiguration(): DomainConfiguration? {

        val cacheResults = databaseRepository.getConfiguration()
        if (cacheResults != null) return cacheResults

        val remoteResults = with(configurationMapper) {
            moviesRetrofitService.getConfigurationAsync()?.fromRemoteToDomain()
        }

        remoteResults?.let {
            databaseRepository.saveConfiguration(it)
        }
        return remoteResults
    }

    override suspend fun discoverMovies(page: Int, map: HashMap<String, String>): List<DomainMovieItem>? =
        with(discoverMoviesMapper) {
            map[PAGE] = "$page"
            moviesRetrofitService.discoverMoviesAsync(map)
                ?.results
                ?.map { it.fromRemoteToDomain() }
        }

    override suspend fun getMovieDetails(
        movieId: String,
        map: HashMap<String, String>
    ): DomainMovieDetails? = with(movieDetailsMapper) {
        map[LANGUAGE] = EN_US
        map[APPEND_TO_RESPONSE] = IMAGES_VIDEOS
        moviesRetrofitService.getMovieDetailsAsync(movieId, map)?.fromRemoteToDomain()
    }

    override suspend fun getMovieDetailsCredits(movieId: String): DomainMovieCredits? =
        with(movieCreditsMapper) {
            moviesRetrofitService.getMovieDetailsCreditsAsync(movieId)?.fromRemoteToDomain()
        }

    override suspend fun getMovieDetailsRecommendations(movieId: String): DomainMovieRecommendations? =
        with(movieRecommendationsMapper) {
            moviesRetrofitService.getMovieDetailsRecommendationsAsync(movieId)?.fromRemoteToDomain()
        }
}
