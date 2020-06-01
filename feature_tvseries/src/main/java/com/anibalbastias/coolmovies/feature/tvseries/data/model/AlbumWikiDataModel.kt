package com.anibalbastias.coolmovies.feature.tvseries.data.model

import com.anibalbastias.coolmovies.feature.tvseries.domain.model.AlbumWikiDomainModel

internal data class AlbumWikiDataModel(
    val published: String,
    val summary: String
)

internal fun AlbumWikiDataModel.toDomainModel() = AlbumWikiDomainModel(
    published = this.published,
    summary = this.summary
)
