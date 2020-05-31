package com.anibalbastias.coolmovies.feature.movies.domain.usecase

import com.anibalbastias.coolmovies.feature.movies.data.repository.RemoteRepositoryImpl
import com.anibalbastias.coolmovies.feature.movies.domain.DomainFixtures
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class GetAlbumListUseCaseTest {

    @MockK
    internal lateinit var mockRemoteRepository: RemoteRepositoryImpl

    private lateinit var cut: GetAlbumListUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        cut = GetAlbumListUseCase(mockRemoteRepository)
    }

    @Test
    fun `return list of albums`() {
        // given
        val albums = listOf(DomainFixtures.getAlbum(), DomainFixtures.getAlbum())
        coEvery { mockRemoteRepository.searchAlbum(any()) } returns albums

        // when
        val result = runBlocking { cut.execute() }

        // then
        result shouldBeEqualTo albums
    }

    @Test
    fun `filter albums without default image`() {
        // given
        val albumWithImage = DomainFixtures.getAlbum()
        val albumWithoutImage = DomainFixtures.getAlbum(images = listOf())
        val albums = listOf(albumWithImage, albumWithoutImage)
        coEvery { mockRemoteRepository.searchAlbum(any()) } returns albums

        // when
        val result = runBlocking { cut.execute() }

        // then
        result shouldBeEqualTo listOf(albumWithImage)
    }
}
