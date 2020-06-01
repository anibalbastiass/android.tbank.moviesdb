package com.anibalbastias.coolmovies.feature.movies.data.model.details

import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.ID
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.NAME
import com.squareup.moshi.Json

data class RemoteMovieGenreItem(
	@field:Json(name = NAME) val name: String? = null,
	@field:Json(name = ID) val id: Int? = null
)