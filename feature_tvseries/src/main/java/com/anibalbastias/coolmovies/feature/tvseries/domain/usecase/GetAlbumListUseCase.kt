package com.anibalbastias.coolmovies.feature.tvseries.domain.usecase

import com.anibalbastias.coolmovies.feature.tvseries.domain.model.AlbumDomainModel
import com.anibalbastias.coolmovies.feature.tvseries.domain.repository.AlbumRepository

internal class GetAlbumListUseCase(
    private val albumRepository: AlbumRepository
) {
    suspend fun execute(): List<AlbumDomainModel> {
        // Due to API limitations we have to perform search with custom phrase to get albums
        val phrase = "sd"

        return albumRepository.searchAlbum(phrase)
            .filter { it.getDefaultImageUrl() != null }
    }
}
