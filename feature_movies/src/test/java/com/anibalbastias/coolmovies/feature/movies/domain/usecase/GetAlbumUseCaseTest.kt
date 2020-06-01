package com.anibalbastias.coolmovies.feature.movies.domain.usecase

import com.anibalbastias.coolmovies.feature.movies.data.repository.RemoteRepositoryImpl
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetAlbumUseCaseTest {

    @MockK
    internal lateinit var mockRemoteRepository: RemoteRepositoryImpl

    private lateinit var cut: GetAlbumUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        cut = GetAlbumUseCase(mockRemoteRepository)
    }

    @Test
    fun `when execute then getAlbum`() {
        // given
        val albumName = "albumName"
        val artistName = "artistName"
        val mbId = "123"

        coEvery { mockRemoteRepository.getAlbumInfo(artistName, albumName, mbId) } answers { mockk() }

        // when
        runBlocking { cut.execute(artistName, albumName, mbId) }

        // then
        coVerify { mockRemoteRepository.getAlbumInfo(artistName, albumName, mbId) }
    }
}
