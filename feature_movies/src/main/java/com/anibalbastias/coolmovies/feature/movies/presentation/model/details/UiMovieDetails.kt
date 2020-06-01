package com.anibalbastias.coolmovies.feature.movies.presentation.model.details

import androidx.databinding.ObservableBoolean

data class UiMovieDetails(
	val originalLanguage: String,
	val imdbId: String,
	val videos: UiMovieVideos?,
	val video: Boolean,
	val title: String,
	val backdropPath: String,
	val revenue: String,
	val genres: List<UiMovieGenreItem>,
	val genresList: String = "",
	val popularity: Double,
	val productionCountries: List<UiMovieProductionCountryItem>,
	val id: Int,
	val voteCount: Int,
	val budget: String,
	val overview: String,
	val images: UiMovieImages?,
	val originalTitle: String,
	val runtime: String,
	val posterPath: String,
	val spokenLanguages: List<UiMovieSpokenLanguageItem>,
	val productionCompanies: List<UiProductionCompanyItem>,
	val releaseDate: String,
	val voteAverage: String,
	val belongsToCollection: UiMovieBelongsToCollection?,
	val tagLine: String,
	val adult: Boolean,
	val homepage: String,
	val status: String,
	var isFavorite: ObservableBoolean
)