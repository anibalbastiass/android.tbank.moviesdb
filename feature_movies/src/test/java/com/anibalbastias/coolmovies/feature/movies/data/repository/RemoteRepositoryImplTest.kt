package com.anibalbastias.coolmovies.feature.movies.data.repository

import com.anibalbastias.coolmovies.feature.movies.data.DataFixtures
import com.anibalbastias.coolmovies.feature.movies.data.model.toDomainModel
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.response.GetAlbumInfoResponse
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.response.SearchAlbumResponse
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.MoviesRetrofitService
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class RemoteRepositoryImplTest {

    @MockK
    internal lateinit var mockService: MoviesRetrofitService

    private lateinit var cut: RemoteRepositoryImpl

    private val artistName = "artistName"
    private val albumName = "albumName"

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        cut = RemoteRepositoryImpl(mockService)
    }

    @Test
    fun `getAlbumInfo fetches AlbumInfo and maps to Model`() {
        // given
        coEvery {
            mockService.getAlbumInfoAsync(artistName, albumName, null)
        } returns GetAlbumInfoResponse(DataFixtures.getAlbum().copy())

        // when
        val result = runBlocking { cut.getAlbumInfo(artistName, albumName, null) }

        // then
        result shouldBeEqualTo DataFixtures.getAlbum().toDomainModel()
    }

    @Test
    fun `getAlbumInfo returns null if response is null`() {
        // given
        coEvery {
            mockService.getAlbumInfoAsync(artistName, albumName, null)
        } returns null

        // when
        val result = runBlocking { cut.getAlbumInfo(artistName, albumName, null) }

        // then
        result shouldBeEqualTo null
    }

    @Test
    fun `searchAlbum fetches AlbumInfo and maps to Model`() {
        // given
        val phrase = "phrase"
        coEvery { mockService.searchAlbumAsync(phrase) } returns SearchAlbumResponse(
            AlbumSearchResultDataModel(
                AlbumListDataModel(listOf(DataFixtures.getAlbum()))
            )
        )

        // when
        val result = runBlocking { cut.searchAlbum(phrase) }

        // then
        result shouldBeEqualTo listOf(DataFixtures.getAlbum().toDomainModel())
    }
}
