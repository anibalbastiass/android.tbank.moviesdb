package com.anibalbastias.coolmovies.feature.movies.data.model

import com.anibalbastias.coolmovies.feature.movies.data.DataFixtures
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class AlbumWikiDataModelTest {

    @Test
    fun `maps to AlbumWikiDomainModel`() {
        // given
        val published = "published"
        val summary = "summary"
        val cut = DataFixtures.getAlbumWikiDataModel(published, summary)

        // when
        val domainModel = cut.toDomainModel()

        // then
        domainModel shouldBeEqualTo AlbumWikiDomainModel(published, summary)
    }
}
