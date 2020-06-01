package com.anibalbastias.coolmovies.feature.movies.presentation.mapper

import androidx.databinding.ObservableBoolean
import com.anibalbastias.coolmovies.feature.movies.domain.model.configuration.DomainConfiguration
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.*
import com.anibalbastias.coolmovies.feature.movies.presentation.model.details.*
import com.anibalbastias.coolmovies.library.base.presentation.extension.applyMilesSeparator
import com.anibalbastias.coolmovies.library.base.presentation.extension.formatDate
import com.anibalbastias.coolmovies.library.base.presentation.extension.minutesToHours
import java.lang.StringBuilder


class UiMovieDetailsMapper {

    private lateinit var config: DomainConfiguration

    fun DomainMovieDetails.fromDomainToUi(uiConfiguration: DomainConfiguration): UiMovieDetails {
        this@UiMovieDetailsMapper.config = uiConfiguration
        return UiMovieDetails(
            originalLanguage = originalLanguage,
            imdbId = imdbId,
            videos = videos?.fromDomainToUi(),
            video = video,
            title = title,
            backdropPath = config.images.run { "$secureBaseUrl${posterSizes[4].trim()}$backdropPath" },
            revenue = "Revenue: $${revenue.applyMilesSeparator()} USD",
            genres = genres.map { it.fromDomainToUi() },
            genresList = "Genres: ${getGenres(genres)}",
            popularity = popularity,
            productionCountries = productionCountries.map { it.fromDomainToUi() },
            id = id,
            voteCount = voteCount,
            budget = "Budget: $${budget.applyMilesSeparator()} USD",
            overview = overview,
            images = images?.fromDomainToUi(),
            originalTitle = originalTitle,
            runtime = "Runtime: ${runtime.minutesToHours()}",
            posterPath = config.images.run { "$secureBaseUrl${posterSizes[4].trim()}$posterPath" },
            spokenLanguages = spokenLanguages.map { it.fromDomainToUi() },
            productionCompanies = productionCompanies.map { it.fromDomainToUi() },
            releaseDate = "Release: ${releaseDate.formatDate()}",
            voteAverage = "Rating: $voteAverage/10",
            belongsToCollection = belongsToCollection?.fromDomainToUi(),
            tagLine = tagLine,
            adult = adult,
            homepage = homepage,
            status = status,
            isFavorite = ObservableBoolean(isFavorite)
        )
    }

    private fun getGenres(genres: List<DomainMovieGenreItem>): String {
        val sb = StringBuilder()
        genres.mapIndexed { index, item ->
            if (index > 0) sb.append(", ")
            sb.append(item.name)
        }
        return sb.toString()
    }

    private fun DomainMovieVideos.fromDomainToUi() = UiMovieVideos(
        results = results.map { it.fromDomainToUi() }
    )

    private fun DomainMovieVideoResultItem.fromDomainToUi() = UiMovieVideoResultItem(
        site = site,
        size = size,
        iso31661 = iso31661,
        name = name,
        id = id,
        type = type,
        iso6391 = iso6391,
        key = "${config.youtubePrefix}$key"
    )

    private fun DomainMovieGenreItem.fromDomainToUi() = UiMovieGenreItem(
        name = name,
        id = id
    )

    private fun DomainMovieImages.fromDomainToUi() = UiMovieImages(
        backdrops = backdrops.map { backdrop ->
            config.images.run {
                "$secureBaseUrl${backDropSizes.last().trim()}$backdrop"
            }
        },
        posters = posters.map { poster ->
            config.images.run {
                "$secureBaseUrl${posterSizes.last().trim()}$poster"
            }
        }
    )

    private fun DomainMovieProductionCountryItem.fromDomainToUi() =
        UiMovieProductionCountryItem(
            iso31661 = iso31661,
            name = name
        )


    private fun DomainProductionCompanyItem.fromDomainToUi() =
        UiProductionCompanyItem(
            logoPath = config.images.run { "$secureBaseUrl${logoSizes.last().trim()}$logoPath" },
            name = name,
            id = id,
            originCountry = originCountry
        )

    private fun DomainMovieSpokenLanguageItem.fromDomainToUi() =
        UiMovieSpokenLanguageItem(
            name = name,
            iso6391 = iso6391
        )

    private fun DomainMovieBelongsToCollection.fromDomainToUi() =
        UiMovieBelongsToCollection(
            backdropPath = config.images.run {
                "$secureBaseUrl${backDropSizes.last().trim()}$backdropPath"
            },
            name = name,
            id = id,
            posterPath = posterPath
        )
}