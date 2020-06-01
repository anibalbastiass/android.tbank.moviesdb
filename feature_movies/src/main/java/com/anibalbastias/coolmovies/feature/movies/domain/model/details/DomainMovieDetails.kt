package com.anibalbastias.coolmovies.feature.movies.domain.model.details

data class DomainMovieDetails(
	val originalLanguage: String,
	val imdbId: String,
	val videos: DomainMovieVideos?,
	val video: Boolean,
	val title: String,
	val backdropPath: String,
	val revenue: Int,
	val genres: List<DomainMovieGenreItem>,
	val popularity: Double,
	val productionCountries: List<DomainMovieProductionCountryItem>,
	val id: Int,
	val voteCount: Int,
	val budget: Int,
	val overview: String,
	val images: DomainMovieImages?,
	val originalTitle: String,
	val runtime: Int,
	val posterPath: String,
	val spokenLanguages: List<DomainMovieSpokenLanguageItem>,
	val productionCompanies: List<DomainProductionCompanyItem>,
	val releaseDate: String,
	val voteAverage: Double,
	val belongsToCollection: DomainMovieBelongsToCollection?,
	val tagLine: String,
	val adult: Boolean,
	val homepage: String,
	val status: String,
	val isFavorite: Boolean
)