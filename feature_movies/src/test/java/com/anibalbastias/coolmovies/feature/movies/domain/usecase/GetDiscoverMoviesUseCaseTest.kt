package com.anibalbastias.coolmovies.feature.movies.domain.usecase

import com.anibalbastias.coolmovies.feature.movies.data.repository.RemoteRepositoryImpl
import com.anibalbastias.coolmovies.feature.movies.factory.ConfigurationFactory
import com.anibalbastias.coolmovies.feature.movies.factory.MoviesListFactory
import com.anibalbastias.coolmovies.library.testutils.foundation.RandomFactory
import com.anibalbastias.coolmovies.library.testutils.foundation.RandomFactory.generateHashMapString
import com.anibalbastias.coolmovies.library.testutils.foundation.RandomFactory.generateInt
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
class GetDiscoverMoviesUseCaseTest {

    @MockK
    internal lateinit var mockRemoteRepository: RemoteRepositoryImpl

    private lateinit var cut: GetDiscoverMoviesUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        cut = GetDiscoverMoviesUseCase(mockRemoteRepository)
    }

    @Test
    fun `return GetDiscoverMovies`() {
        // given
        val page = generateInt()
        val map = generateHashMapString()
        val discoverMovies = (0..5).map { MoviesListFactory.makeDomainMovieItem() }
        coEvery {
            mockRemoteRepository.discoverMovies(page, map)
        } returns discoverMovies

        // when
        val result = runBlocking { cut.execute(page, map) }

        // then
        result shouldBeEqualTo discoverMovies
    }
}