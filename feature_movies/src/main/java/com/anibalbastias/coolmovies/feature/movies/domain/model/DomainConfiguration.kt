package com.anibalbastias.coolmovies.feature.movies.domain.model

data class DomainConfiguration(
    val images: DomainConfigurationImages,
    val changeKeys: List<String>
)
