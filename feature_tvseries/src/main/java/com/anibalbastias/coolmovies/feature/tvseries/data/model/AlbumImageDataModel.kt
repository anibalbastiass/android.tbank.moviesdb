package com.anibalbastias.coolmovies.feature.tvseries.data.model

import com.anibalbastias.coolmovies.feature.tvseries.data.enum.AlbumDataImageSize
import com.anibalbastias.coolmovies.feature.tvseries.data.enum.toDomainEnum
import com.anibalbastias.coolmovies.feature.tvseries.domain.model.AlbumImageDomainModel
import com.squareup.moshi.Json

internal data class AlbumImageDataModel(
    @field:Json(name = "#text") val url: String,
    val size: AlbumDataImageSize
)

internal fun AlbumImageDataModel.toDomainModel() = AlbumImageDomainModel(
    url = this.url,
    size = this.size.toDomainEnum()
)
