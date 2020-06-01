package com.anibalbastias.coolmovies.feature.movies.data.model.details

import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.BACKDROPS
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.POSTERS
import com.squareup.moshi.Json

data class RemoteMovieImages(
	@field:Json(name = BACKDROPS) val backdrops: List<String?>? = null,
	@field:Json(name = POSTERS) val posters: List<String?>? = null
)