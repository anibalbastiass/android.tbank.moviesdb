package com.anibalbastias.coolmovies.feature.movies.data.mapper

import com.anibalbastias.coolmovies.feature.movies.data.model.details.*
import com.anibalbastias.coolmovies.feature.movies.domain.model.details.*

class MovieDetailsMapper {

    companion object {
        const val DEFAULT_STRING: String = ""
        const val DEFAULT_INT: Int = 0
        const val DEFAULT_DOUBLE: Double = 0.0
        const val DEFAULT_BOOLEAN: Boolean = false
    }

    fun RemoteMovieDetails.fromRemoteToDomain() =
        DomainMovieDetails(
            originalLanguage = originalLanguage ?: DEFAULT_STRING,
            imdbId = imdbId ?: DEFAULT_STRING,
            videos = videos?.fromRemoteToDomain(),
            video = video ?: DEFAULT_BOOLEAN,
            title = title ?: DEFAULT_STRING,
            backdropPath = backdropPath ?: DEFAULT_STRING,
            revenue = revenue ?: DEFAULT_INT,
            genres = genres?.map { it?.fromRemoteToDomain()!! }!!,
            popularity = popularity ?: DEFAULT_DOUBLE,
            productionCountries = productionCountries?.map { it?.fromRemoteToDomain()!! }!!,
            id = id ?: DEFAULT_INT,
            voteCount = voteCount ?: DEFAULT_INT,
            budget = budget ?: DEFAULT_INT,
            overview = overview ?: DEFAULT_STRING,
            images = images?.fromRemoteToDomain(),
            originalTitle = originalTitle ?: DEFAULT_STRING,
            runtime = runtime ?: DEFAULT_INT,
            posterPath = posterPath ?: DEFAULT_STRING,
            spokenLanguages = spokenLanguages?.map { it?.fromRemoteToDomain()!! }!!,
            productionCompanies = productionCompanies?.map { it?.fromRemoteToDomain()!! }!!,
            releaseDate = releaseDate ?: DEFAULT_STRING,
            voteAverage = voteAverage ?: DEFAULT_DOUBLE,
            belongsToCollection = belongsToCollection?.fromRemoteToDomain(),
            tagLine = tagLine ?: DEFAULT_STRING,
            adult = adult ?: DEFAULT_BOOLEAN,
            homepage = homepage ?: DEFAULT_STRING,
            status = status ?: DEFAULT_STRING,
            isFavorite = DEFAULT_BOOLEAN
        )

    private fun RemoteMovieVideos.fromRemoteToDomain() = DomainMovieVideos(
        results = results?.map { it?.fromRemoteToDomain()!! }!!
    )

    private fun RemoteMovieVideoResultItem.fromRemoteToDomain() = DomainMovieVideoResultItem(
        site = site ?: DEFAULT_STRING,
        size = size ?: DEFAULT_INT,
        iso31661 = iso31661 ?: DEFAULT_STRING,
        name = name ?: DEFAULT_STRING,
        id = id ?: DEFAULT_STRING,
        type = type ?: DEFAULT_STRING,
        iso6391 = iso6391 ?: DEFAULT_STRING,
        key = key ?: DEFAULT_STRING
    )

    private fun RemoteMovieGenreItem.fromRemoteToDomain() = DomainMovieGenreItem(
        name = name ?: DEFAULT_STRING,
        id = id ?: DEFAULT_INT
    )

    private fun RemoteMovieImages.fromRemoteToDomain() = DomainMovieImages(
        backdrops = backdrops as List<String>,
        posters = posters as List<String>
    )

    private fun RemoteMovieProductionCountryItem.fromRemoteToDomain() =
        DomainMovieProductionCountryItem(
            iso31661 = iso31661 ?: DEFAULT_STRING,
            name = name ?: DEFAULT_STRING
        )


    private fun RemoteProductionCompanyItem.fromRemoteToDomain() =
        DomainProductionCompanyItem(
            logoPath = logoPath ?: DEFAULT_STRING,
            name = name ?: DEFAULT_STRING,
            id = id ?: DEFAULT_INT,
            originCountry = originCountry ?: DEFAULT_STRING
        )

    private fun RemoteMovieSpokenLanguageItem.fromRemoteToDomain() =
        DomainMovieSpokenLanguageItem(
            name = name ?: DEFAULT_STRING,
            iso6391 = iso6391 ?: DEFAULT_STRING
        )

    private fun RemoteMovieBelongsToCollection.fromRemoteToDomain() =
        DomainMovieBelongsToCollection(
            backdropPath = backdropPath ?: DEFAULT_STRING,
            name = name ?: DEFAULT_STRING,
            id = id ?: DEFAULT_INT,
            posterPath = posterPath ?: DEFAULT_STRING
        )
}