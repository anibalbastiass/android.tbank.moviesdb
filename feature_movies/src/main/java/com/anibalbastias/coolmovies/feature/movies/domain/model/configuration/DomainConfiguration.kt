package com.anibalbastias.coolmovies.feature.movies.domain.model.configuration

data class DomainConfiguration(
    val images: DomainConfigurationImages,
    val changeKeys: List<String>
)
