package com.anibalbastias.coolmovies.feature.movies.domain.database

import com.anibalbastias.coolmovies.feature.movies.data.room.MoviesDatabase
import com.anibalbastias.coolmovies.feature.movies.domain.mapper.BdConfigurationMapper
import com.anibalbastias.coolmovies.feature.movies.domain.model.DomainConfiguration
import com.anibalbastias.coolmovies.feature.movies.domain.repository.DatabaseRepository

open class DatabaseRepositoryImpl(
    private val mapper: BdConfigurationMapper,
    private val moviesDatabase: MoviesDatabase
) : DatabaseRepository {

    override suspend fun getConfiguration(): DomainConfiguration? =
        with(mapper) {
            return moviesDatabase.configuration.getConfiguration()?.fromDatabaseToDomain()
        }

    override suspend fun saveConfiguration(configuration: DomainConfiguration) =
        with(mapper) {
            moviesDatabase.configuration.saveConfiguration(configuration.fromDomainToDatabase())
        }

}
