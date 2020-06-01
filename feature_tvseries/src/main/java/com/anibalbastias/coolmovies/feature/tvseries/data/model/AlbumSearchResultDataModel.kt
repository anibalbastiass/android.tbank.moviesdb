package com.anibalbastias.coolmovies.feature.tvseries.data.model

import com.squareup.moshi.Json

internal data class AlbumSearchResultDataModel(
    @field:Json(name = "albummatches") val albumMatches: AlbumListDataModel
)
