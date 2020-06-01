package com.anibalbastias.coolmovies.feature.movies.data.model.details

import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.BACKDROP_PATH
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.ID
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.NAME
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.POSTER_PATH
import com.squareup.moshi.Json

data class RemoteMovieBelongsToCollection(
    @field:Json(name = BACKDROP_PATH) val backdropPath: String? = null,
    @field:Json(name = NAME) val name: String? = null,
    @field:Json(name = ID) val id: Int? = null,
    @field:Json(name = POSTER_PATH) val posterPath: String? = null
)