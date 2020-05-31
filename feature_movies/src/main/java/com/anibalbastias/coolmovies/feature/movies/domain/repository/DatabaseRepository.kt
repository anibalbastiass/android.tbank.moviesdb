package com.anibalbastias.coolmovies.feature.movies.domain.repository

import com.anibalbastias.coolmovies.feature.movies.domain.model.DomainConfiguration


interface DatabaseRepository {
    suspend fun getConfiguration(): DomainConfiguration?
    suspend fun saveConfiguration(configuration: DomainConfiguration)
}
