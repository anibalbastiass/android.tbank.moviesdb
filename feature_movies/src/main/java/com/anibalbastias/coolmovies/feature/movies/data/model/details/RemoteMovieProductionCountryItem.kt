package com.anibalbastias.coolmovies.feature.movies.data.model.details

import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.ISO_3166_1
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.NAME
import com.squareup.moshi.Json

data class RemoteMovieProductionCountryItem(
    @field:Json(name = ISO_3166_1) val iso31661: String? = null,
    @field:Json(name = NAME) val name: String? = null
)