package com.anibalbastias.coolmovies.feature.movies.presentation.model.details.recommendations

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class UiMovieRecommendationsResults(
    val overview: String = "",
    val originalLanguage: String = "",
    val originalTitle: String = "",
    val video: Boolean = false,
    val title: String = "",
    val genreIds: List<Int> = arrayListOf(),
    val posterPath: String = "",
    val backdropPath: String = "",
    val releaseDate: String = "",
    val voteAverage: Double = 0.0,
    val popularity: Double = 0.0,
    val id: Int = 0,
    val adult: Boolean = false,
    val voteCount: Int = 0
): Parcelable {
    companion object {
        fun create() = UiMovieRecommendationsResults()
    }
}