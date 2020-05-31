package com.anibalbastias.coolmovies.feature.movies.data.model

import com.anibalbastias.coolmovies.feature.movies.data.DataFixtures
import com.anibalbastias.coolmovies.feature.movies.data.enum.AlbumDataImageSize
import com.anibalbastias.coolmovies.feature.movies.data.enum.toDomainEnum
import org.amshove.kluent.shouldThrow
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class AlbumImageDataModelTest {

    @Test
    fun `maps to AlbumWikiDomainModel`() {
        // given
        val url = "url"
        val size = AlbumDataImageSize.EXTRA_LARGE
        val cut = DataFixtures.getAlbumImage(url, size)

        // when
        val domainModel = cut.toDomainModel()

        // then
        domainModel shouldBeEqualTo AlbumImageDomainModel(url, size.toDomainEnum())
    }

    @Test
    fun `crash when mapping unknown AlbumWikiDomainModel`() {
        // given
        val url = "url"
        val size = AlbumDataImageSize.UNKNOWN
        val cut = DataFixtures.getAlbumImage(url, size)

        // when
        val func = { cut.toDomainModel() }

        // then
        func shouldThrow IllegalArgumentException::class
    }
}
