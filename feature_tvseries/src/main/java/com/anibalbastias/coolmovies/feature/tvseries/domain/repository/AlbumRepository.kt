package com.anibalbastias.coolmovies.feature.tvseries.domain.repository

import com.anibalbastias.coolmovies.feature.tvseries.domain.model.AlbumDomainModel

internal interface AlbumRepository {

    suspend fun getAlbumInfo(artistName: String, albumName: String, mbId: String?): AlbumDomainModel?

    suspend fun searchAlbum(phrase: String): List<AlbumDomainModel>
}
