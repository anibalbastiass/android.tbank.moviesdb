package com.anibalbastias.coolmovies.feature.movies.domain.model.configuration

import com.anibalbastias.coolmovies.BuildConfig

data class DomainConfiguration(
    val images: DomainConfigurationImages,
    val changeKeys: List<String>,
    val youtubePrefix: String = BuildConfig.GRADLE_YOUTUBE_URL
)
