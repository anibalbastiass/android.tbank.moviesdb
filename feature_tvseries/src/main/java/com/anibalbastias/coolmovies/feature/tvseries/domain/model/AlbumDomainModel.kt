package com.anibalbastias.coolmovies.feature.tvseries.domain.model

import com.anibalbastias.coolmovies.feature.tvseries.domain.enum.AlbumDomainImageSize

internal data class AlbumDomainModel(
    val name: String,
    val artist: String,
    val images: List<AlbumImageDomainModel>,
    val wiki: AlbumWikiDomainModel? = null,
    val mbId: String? = null
) {
    fun getDefaultImageUrl() = images.firstOrNull { it.size == AlbumDomainImageSize.EXTRA_LARGE }?.url
}
