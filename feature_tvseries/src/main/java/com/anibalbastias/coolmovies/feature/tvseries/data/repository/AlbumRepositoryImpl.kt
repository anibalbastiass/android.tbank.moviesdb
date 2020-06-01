package com.anibalbastias.coolmovies.feature.tvseries.data.repository

import com.anibalbastias.coolmovies.feature.tvseries.data.model.toDomainModel
import com.anibalbastias.coolmovies.feature.tvseries.data.retrofit.service.AlbumRetrofitService
import com.anibalbastias.coolmovies.feature.tvseries.domain.repository.AlbumRepository

internal class AlbumRepositoryImpl(
    private val albumRetrofitService: AlbumRetrofitService
) : AlbumRepository {

    override suspend fun getAlbumInfo(artistName: String, albumName: String, mbId: String?) =
        albumRetrofitService.getAlbumInfoAsync(artistName, albumName, mbId)
            ?.album
            ?.toDomainModel()

    override suspend fun searchAlbum(phrase: String) =
        albumRetrofitService.searchAlbumAsync(phrase)
            .results
            .albumMatches
            .album
            .map { it.toDomainModel() }
}
