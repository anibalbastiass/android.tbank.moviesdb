package com.anibalbastias.coolmovies.feature.movies.domain.usecase

import com.anibalbastias.coolmovies.feature.movies.data.repository.RemoteRepositoryImpl
import com.anibalbastias.coolmovies.feature.movies.factory.ConfigurationFactory
import com.anibalbastias.coolmovies.feature.movies.factory.MoviesDetailsFactory
import com.anibalbastias.coolmovies.library.testutils.foundation.RandomFactory
import com.anibalbastias.coolmovies.library.testutils.foundation.RandomFactory.generateString
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
class GetMovieCreditsUseCaseTest {
    @MockK
    internal lateinit var mockRemoteRepository: RemoteRepositoryImpl

    private lateinit var cut: GetMovieCreditsUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        cut = GetMovieCreditsUseCase(mockRemoteRepository)
    }

    @Test
    fun `return configuration`() {
        // given
        val movieId = generateString()
        val credits = MoviesDetailsFactory.makeDomainMovieCredits()
        coEvery { mockRemoteRepository.getMovieDetailsCredits(movieId) } returns credits

        // when
        val result = runBlocking { cut.execute(movieId) }

        // then
        result shouldBeEqualTo credits
    }
}