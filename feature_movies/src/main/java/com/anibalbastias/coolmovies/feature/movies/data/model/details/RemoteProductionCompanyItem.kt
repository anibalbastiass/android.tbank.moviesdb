package com.anibalbastias.coolmovies.feature.movies.data.model.details

import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.ID
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.LOGO_PATH
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.NAME
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.ORIGIN_COUNTRY
import com.squareup.moshi.Json

data class RemoteProductionCompanyItem(
	@field:Json(name = LOGO_PATH) val logoPath: String? = null,
	@field:Json(name = NAME) val name: String? = null,
	@field:Json(name = ID) val id: Int? = null,
	@field:Json(name = ORIGIN_COUNTRY) val originCountry: String? = null
)