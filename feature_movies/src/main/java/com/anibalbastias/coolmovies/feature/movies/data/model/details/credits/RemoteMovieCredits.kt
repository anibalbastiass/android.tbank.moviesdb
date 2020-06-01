package com.anibalbastias.coolmovies.feature.movies.data.model.details.credits

import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.CAST
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.CREW
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.ID
import com.squareup.moshi.Json

data class RemoteMovieCredits(
	@field:Json(name = CAST) val cast: List<RemoteMovieCast?>? = null,
	@field:Json(name = ID) val id: Int? = null,
	@field:Json(name = CREW) val crew: List<RemoteMovieCrew?>? = null
)