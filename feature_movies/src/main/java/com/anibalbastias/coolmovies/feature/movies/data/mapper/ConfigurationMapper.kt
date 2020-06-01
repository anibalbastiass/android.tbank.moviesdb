package com.anibalbastias.coolmovies.feature.movies.data.mapper

import com.anibalbastias.coolmovies.feature.movies.data.model.RemoteConfiguration
import com.anibalbastias.coolmovies.feature.movies.data.model.configuration.RemoteConfigurationImages
import com.anibalbastias.coolmovies.feature.movies.domain.model.configuration.DomainConfiguration
import com.anibalbastias.coolmovies.feature.movies.domain.model.configuration.DomainConfigurationImages

class ConfigurationMapper {

    companion object {
        const val DEFAULT_STRING = ""
    }

    fun RemoteConfiguration.fromRemoteToDomain() =
        DomainConfiguration(
            images = images.fromRemoteToDomain(),
            changeKeys = changeKeys ?: arrayListOf()
        )

    private fun RemoteConfigurationImages.fromRemoteToDomain() =
        DomainConfigurationImages(
            baseUrl = baseUrl ?: DEFAULT_STRING,
            secureBaseUrl = secureBaseUrl ?: DEFAULT_STRING,
            backDropSizes = backDropSizes ?: arrayListOf(),
            logoSizes = logoSizes ?: arrayListOf(),
            posterSizes = posterSizes ?: arrayListOf(),
            profileSizes = profileSizes ?: arrayListOf(),
            stillSizes = stillSizes ?: arrayListOf()
        )
}