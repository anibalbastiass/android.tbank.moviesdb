package com.anibalbastias.coolmovies.feature.movies.data.model.details.recommendations

import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.ADULT
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.BACKDROP_PATH
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.GENRE_IDS
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.ID
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.ORIGINAL_LANGUAGE
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.ORIGINAL_TITLE
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.OVERVIEW
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.POPULARITY
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.POSTER_PATH
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.RELEASE_DATE
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.TITLE
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.VIDEO
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.VOTE_AVERAGE
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.VOTE_COUNT
import com.squareup.moshi.Json

data class RemoteMovieRecommendationsResults(
	@field:Json(name = OVERVIEW) val overview: String? = null,
	@field:Json(name = ORIGINAL_LANGUAGE) val originalLanguage: String? = null,
	@field:Json(name = ORIGINAL_TITLE) val originalTitle: String? = null,
	@field:Json(name = VIDEO) val video: Boolean? = null,
	@field:Json(name = TITLE) val title: String? = null,
	@field:Json(name = GENRE_IDS) val genreIds: List<Int?>? = null,
	@field:Json(name = POSTER_PATH) val posterPath: String? = null,
	@field:Json(name = BACKDROP_PATH) val backdropPath: String? = null,
	@field:Json(name = RELEASE_DATE) val releaseDate: String? = null,
	@field:Json(name = VOTE_AVERAGE) val voteAverage: Double? = null,
	@field:Json(name = POPULARITY) val popularity: Double? = null,
	@field:Json(name = ID) val id: Int? = null,
	@field:Json(name = ADULT) val adult: Boolean? = null,
	@field:Json(name = VOTE_COUNT) val voteCount: Int? = null
)