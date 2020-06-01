package com.anibalbastias.coolmovies.feature.movies.data.repository

import com.anibalbastias.coolmovies.feature.movies.data.mapper.ConfigurationMapper
import com.anibalbastias.coolmovies.feature.movies.data.mapper.DiscoverMoviesMapper
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.MoviesRetrofitService
import com.anibalbastias.coolmovies.feature.movies.domain.model.DomainConfiguration
import com.anibalbastias.coolmovies.feature.movies.domain.model.DomainMovieItem
import com.anibalbastias.coolmovies.feature.movies.domain.repository.DatabaseRepository
import com.anibalbastias.coolmovies.feature.movies.domain.repository.MoviesRepository

internal class RemoteRepositoryImpl(
    private val moviesRetrofitService: MoviesRetrofitService,
    private val configurationMapper: ConfigurationMapper,
    private val discoverMoviesMapper: DiscoverMoviesMapper,
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

    override suspend fun discoverMovies(map: HashMap<String, String>): List<DomainMovieItem>? =
        with(discoverMoviesMapper) {
            moviesRetrofitService.discoverMoviesAsync(map)
                ?.results
                ?.map { it.fromRemoteToDomain() }
        }
}
