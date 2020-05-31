package com.anibalbastias.coolmovies.feature.movies.data.model

import com.anibalbastias.coolmovies.feature.movies.data.model.movie.RemoteMovieItem
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.PAGE
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.RESULTS
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.TOTAL_PAGES
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.TOTAL_RESULTS
import com.squareup.moshi.Json

internal data class RemoteDiscoverMovies(
    @field:Json(name = PAGE) val page: Int,
    @field:Json(name = TOTAL_RESULTS) val totalResults: Int,
    @field:Json(name = TOTAL_PAGES) val totalPages: Int,
    @field:Json(name = RESULTS) val results: List<RemoteMovieItem>?
)
