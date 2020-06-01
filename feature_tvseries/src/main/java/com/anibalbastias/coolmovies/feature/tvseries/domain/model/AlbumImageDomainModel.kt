package com.anibalbastias.coolmovies.feature.tvseries.domain.model

import com.anibalbastias.coolmovies.feature.tvseries.domain.enum.AlbumDomainImageSize

internal data class AlbumImageDomainModel(
    val url: String,
    val size: AlbumDomainImageSize
)
