package com.anibalbastias.coolmovies.feature.movies.data.model.movie

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

data class RemoteMovieItem(
    @field:Json(name = POPULARITY) val popularity: Double,
    @field:Json(name = VOTE_COUNT) val voteCount: Long,
    @field:Json(name = VIDEO) val video: Boolean,
    @field:Json(name = POSTER_PATH) val posterPath: String,
    @field:Json(name = ID) val id: Long,
    @field:Json(name = ADULT) val adult: Boolean,
    @field:Json(name = BACKDROP_PATH) val backDropPath: String,
    @field:Json(name = ORIGINAL_LANGUAGE) val originalLanguage: String,
    @field:Json(name = ORIGINAL_TITLE) val originalTitle: String,
    @field:Json(name = GENRE_IDS) val genreIds: List<Long>,
    @field:Json(name = TITLE) val title: String,
    @field:Json(name = VOTE_AVERAGE) val voteAverage: Double,
    @field:Json(name = OVERVIEW) val overview: String,
    @field:Json(name = RELEASE_DATE) val releaseDate: String
)
