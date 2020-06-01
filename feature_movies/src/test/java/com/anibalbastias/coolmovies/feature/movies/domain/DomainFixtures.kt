package com.anibalbastias.coolmovies.feature.movies.domain

import com.anibalbastias.coolmovies.feature.movies.domain.enum.AlbumDomainImageSize

object DomainFixtures {

    internal fun getAlbum(
        name: String = "albumName",
        artist: String = "artistName",
        images: List<AlbumImageDomainModel> = listOf(getAlbumImage()),
        wiki: AlbumWikiDomainModel? = getAlbumWikiDomainModel(),
        mbId: String? = "mbId"
    ): AlbumDomainModel = AlbumDomainModel(name, artist, images, wiki, mbId)

    internal fun getAlbumImage(
        url: String = "url_${AlbumDomainImageSize.EXTRA_LARGE}",
        size: AlbumDomainImageSize = AlbumDomainImageSize.EXTRA_LARGE
    ) = AlbumImageDomainModel(url, size)

    private fun getAlbumWikiDomainModel(
        published: String = "published",
        summary: String = "summary"
    ) = AlbumWikiDomainModel(published, summary)
}
