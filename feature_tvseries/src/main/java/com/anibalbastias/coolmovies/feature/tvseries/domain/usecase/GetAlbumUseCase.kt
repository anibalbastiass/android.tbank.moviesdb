package com.anibalbastias.coolmovies.feature.tvseries.domain.usecase

import com.anibalbastias.coolmovies.feature.tvseries.domain.repository.AlbumRepository

internal class GetAlbumUseCase(
    private val albumRepository: AlbumRepository
) {
    suspend fun execute(
        artistName: String,
        albumName: String,
        mbId: String?
    ) = albumRepository.getAlbumInfo(artistName, albumName, mbId)
}
