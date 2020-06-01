package com.anibalbastias.coolmovies.feature.movies.data.model.details

import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.RESULTS
import com.squareup.moshi.Json

data class RemoteMovieVideos(
    @field:Json(name = RESULTS) val results: List<RemoteMovieVideoResultItem?>? = null
)