package com.anibalbastias.coolmovies.feature.tvseries.data

import com.anibalbastias.coolmovies.feature.tvseries.data.enum.AlbumDataImageSize
import com.anibalbastias.coolmovies.feature.tvseries.data.model.AlbumDataModel
import com.anibalbastias.coolmovies.feature.tvseries.data.model.AlbumImageDataModel
import com.anibalbastias.coolmovies.feature.tvseries.data.model.AlbumWikiDataModel

object DataFixtures {

    internal fun getAlbum(
        mbId: String? = "mbId",
        name: String = "albumName",
        artist: String = "artistName",
        wiki: AlbumWikiDataModel? = getAlbumWikiDataModel(),
        images: List<AlbumImageDataModel>? = listOf(getAlbumImage())
    ): AlbumDataModel = AlbumDataModel(mbId, name, artist, wiki, images)

    internal fun getMinimalAlbum(): AlbumDataModel =
        getAlbum(
            name = "name",
            artist = "artist",
            mbId = null,
            wiki = null,
            images = null
        )

    internal fun getAlbumImage(
        url: String = "url_${AlbumDataImageSize.EXTRA_LARGE}",
        size: AlbumDataImageSize = AlbumDataImageSize.EXTRA_LARGE
    ) = AlbumImageDataModel(url, size)

    internal fun getAlbumWikiDataModel(
        published: String = "published",
        summary: String = "summary"
    ) = AlbumWikiDataModel(published, summary)
}
