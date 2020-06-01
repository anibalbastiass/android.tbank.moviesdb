package com.anibalbastias.coolmovies.feature.movies.data.model.details

import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.ID
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.ISO_3166_1
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.ISO_639_1
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.KEY
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.NAME
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.SITE
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.SIZE
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.TYPE
import com.squareup.moshi.Json

data class RemoteMovieVideoResultItem(
	@field:Json(name = SITE) val site: String? = null,
	@field:Json(name = SIZE) val size: Int? = null,
	@field:Json(name = ISO_3166_1) val iso31661: String? = null,
	@field:Json(name = NAME) val name: String? = null,
	@field:Json(name = ID) val id: String? = null,
	@field:Json(name = TYPE) val type: String? = null,
	@field:Json(name = ISO_639_1) val iso6391: String? = null,
	@field:Json(name = KEY) val key: String? = null
)