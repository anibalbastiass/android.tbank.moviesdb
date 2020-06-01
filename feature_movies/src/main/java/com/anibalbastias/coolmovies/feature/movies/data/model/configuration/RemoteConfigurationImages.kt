package com.anibalbastias.coolmovies.feature.movies.data.model.configuration

import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.BACK_DROP_SIZES
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.BASE_URL
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.LOGO_SIZES
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.POSTER_SIZES
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.PROFILE_SIZES
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.SECURE_BASE_URL
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.STILL_SIZES
import com.squareup.moshi.Json

data class RemoteConfigurationImages(
    @field:Json(name = BASE_URL) val baseUrl: String?,
    @field:Json(name = SECURE_BASE_URL) val secureBaseUrl: String?,
    @field:Json(name = BACK_DROP_SIZES) val backDropSizes: List<String>?,
    @field:Json(name = LOGO_SIZES) val logoSizes: List<String>?,
    @field:Json(name = POSTER_SIZES) val posterSizes: List<String>?,
    @field:Json(name = PROFILE_SIZES) val profileSizes: List<String>?,
    @field:Json(name = STILL_SIZES) val stillSizes: List<String>?
)
