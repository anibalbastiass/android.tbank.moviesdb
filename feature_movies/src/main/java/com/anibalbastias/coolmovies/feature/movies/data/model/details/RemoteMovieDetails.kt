package com.anibalbastias.coolmovies.feature.movies.data.model.details

import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.ADULT
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.BACKDROP_PATH
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.BELONGS_TO_COLLECTION
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.BUDGET
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.GENRES
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.HOME_PAGE
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.ID
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.IMAGES
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.IMDB_ID
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.ORIGINAL_LANGUAGE
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.ORIGINAL_TITLE
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.OVERVIEW
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.POPULARITY
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.POSTER_PATH
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.PRODUCTION_COMPANIES
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.PRODUCTION_COUNTRIES
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.RELEASE_DATE
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.REVENUE
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.RUNTIME
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.SPOKEN_LANGUAGES
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.STATUS
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.TAGLINE
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.TITLE
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.VIDEO
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.VIDEOS
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.VOTE_AVERAGE
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.VOTE_COUNT
import com.squareup.moshi.Json

data class RemoteMovieDetails(
	@field:Json(name = ORIGINAL_LANGUAGE) val originalLanguage: String? = null,
	@field:Json(name = IMDB_ID) val imdbId: String? = null,
	@field:Json(name = VIDEOS) val videos: RemoteMovieVideos? = null,
	@field:Json(name = VIDEO) val video: Boolean? = null,
	@field:Json(name = TITLE) val title: String? = null,
	@field:Json(name = BACKDROP_PATH) val backdropPath: String? = null,
	@field:Json(name = REVENUE) val revenue: Int? = null,
	@field:Json(name = GENRES) val genres: List<RemoteMovieGenreItem?>? = null,
	@field:Json(name = POPULARITY) val popularity: Double? = null,
	@field:Json(name = PRODUCTION_COUNTRIES) val productionCountries: List<RemoteMovieProductionCountryItem?>? = null,
	@field:Json(name = ID) val id: Int? = null,
	@field:Json(name = VOTE_COUNT) val voteCount: Int? = null,
	@field:Json(name = BUDGET) val budget: Int? = null,
	@field:Json(name = OVERVIEW) val overview: String? = null,
	@field:Json(name = IMAGES) val images: RemoteMovieImages? = null,
	@field:Json(name = ORIGINAL_TITLE) val originalTitle: String? = null,
	@field:Json(name = RUNTIME) val runtime: Int? = null,
	@field:Json(name = POSTER_PATH) val posterPath: String? = null,
	@field:Json(name = SPOKEN_LANGUAGES) val spokenLanguages: List<RemoteMovieSpokenLanguageItem?>? = null,
	@field:Json(name = PRODUCTION_COMPANIES) val productionCompanies: List<RemoteProductionCompanyItem?>? = null,
	@field:Json(name = RELEASE_DATE) val releaseDate: String? = null,
	@field:Json(name = VOTE_AVERAGE) val voteAverage: Double? = null,
	@field:Json(name = BELONGS_TO_COLLECTION) val belongsToCollection: RemoteMovieBelongsToCollection? = null,
	@field:Json(name = TAGLINE) val tagLine: String? = null,
	@field:Json(name = ADULT) val adult: Boolean? = null,
	@field:Json(name = HOME_PAGE) val homepage: String? = null,
	@field:Json(name = STATUS) val status: String? = null
)