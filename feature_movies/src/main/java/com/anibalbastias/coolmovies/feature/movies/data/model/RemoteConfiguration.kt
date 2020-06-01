package com.anibalbastias.coolmovies.feature.movies.data.model

import com.anibalbastias.coolmovies.feature.movies.data.model.configuration.RemoteConfigurationImages
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.CHANGE_KEYS
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.IMAGES
import com.squareup.moshi.Json

data class RemoteConfiguration(
    @field:Json(name = IMAGES) val images: RemoteConfigurationImages,
    @field:Json(name = CHANGE_KEYS) val changeKeys: List<String>?
)
