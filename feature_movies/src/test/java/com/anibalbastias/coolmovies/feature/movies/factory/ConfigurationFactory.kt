package com.anibalbastias.coolmovies.feature.movies.factory

import com.anibalbastias.coolmovies.feature.movies.data.model.RemoteConfiguration
import com.anibalbastias.coolmovies.feature.movies.data.model.configuration.RemoteConfigurationImages
import com.anibalbastias.coolmovies.feature.movies.domain.model.configuration.DomainConfiguration
import com.anibalbastias.coolmovies.feature.movies.domain.model.configuration.DomainConfigurationImages
import com.anibalbastias.coolmovies.library.testutils.foundation.RandomFactory.generateArrayString
import com.anibalbastias.coolmovies.library.testutils.foundation.RandomFactory.generateString

object ConfigurationFactory {

    fun makeRemoteConfiguration() = RemoteConfiguration(
        images = makeRemoteConfigurationImages(),
        changeKeys = generateArrayString()
    )

    private fun makeRemoteConfigurationImages() = RemoteConfigurationImages(
        baseUrl = generateString(),
        secureBaseUrl = generateString(),
        backDropSizes = generateArrayString(),
        logoSizes = generateArrayString(),
        posterSizes = generateArrayString(),
        profileSizes = generateArrayString(),
        stillSizes = generateArrayString()
    )

    fun makeDomainConfiguration() = DomainConfiguration(
        images = makeDomainConfigurationImages(),
        changeKeys = generateArrayString()
    )

    private fun makeDomainConfigurationImages() = DomainConfigurationImages(
        baseUrl = generateString(),
        secureBaseUrl = generateString(),
        backDropSizes = generateArrayString(),
        logoSizes = generateArrayString(),
        posterSizes = generateArrayString(),
        profileSizes = generateArrayString(),
        stillSizes = generateArrayString()
    )
}