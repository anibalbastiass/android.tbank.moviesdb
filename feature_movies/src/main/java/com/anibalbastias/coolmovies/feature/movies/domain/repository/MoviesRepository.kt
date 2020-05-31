package com.anibalbastias.coolmovies.feature.movies.domain.repository

import com.anibalbastias.coolmovies.feature.movies.domain.model.DomainConfiguration
import com.anibalbastias.coolmovies.feature.movies.domain.model.DomainMovieItem

internal interface MoviesRepository {

    suspend fun getConfiguration(): DomainConfiguration?

    suspend fun discoverMovies(map: HashMap<String, String>): List<DomainMovieItem>?

}
