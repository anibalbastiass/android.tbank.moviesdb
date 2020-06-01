package com.anibalbastias.coolmovies.feature.movies.domain.model

data class DomainConfigurationImages(
    val baseUrl: String,
    val secureBaseUrl: String,
    val backDropSizes: List<String>,
    val logoSizes: List<String>,
    val posterSizes: List<String>,
    val profileSizes: List<String>,
    val stillSizes: List<String>
)
