package com.anibalbastias.coolmovies.feature.movies.data.model.details.recommendations

import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.PAGE
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.RESULTS
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.TOTAL_PAGES
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.TOTAL_RESULTS
import com.squareup.moshi.Json

data class RemoteMovieRecommendations(
	@field:Json(name = PAGE) val page: Int? = null,
	@field:Json(name = TOTAL_PAGES) val totalPages: Int? = null,
	@field:Json(name = RESULTS) val results: List<RemoteMovieRecommendationsResults?>? = null,
	@field:Json(name = TOTAL_RESULTS) val totalResults: Int? = null
)