package com.anibalbastias.coolmovies.feature.movies.domain.usecase

import com.anibalbastias.coolmovies.feature.movies.data.repository.RemoteRepositoryImpl
import com.anibalbastias.coolmovies.feature.movies.factory.MoviesDetailsFactory
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
class GetMovieRecommendationsUseCaseTest {
    @MockK
    internal lateinit var mockRemoteRepository: RemoteRepositoryImpl

    private lateinit var cut: GetMovieRecommendationsUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        cut = GetMovieRecommendationsUseCase(mockRemoteRepository)
    }

    @Test
    fun `return configuration`() {
        // given
        val movieId = generateString()
        val recommendations = MoviesDetailsFactory.makeDomainMovieRecommendations()
        coEvery { mockRemoteRepository.getMovieDetailsRecommendations(movieId) } returns recommendations

        // when
        val result = runBlocking { cut.execute(movieId) }

        // then
        result shouldBeEqualTo recommendations
    }
}