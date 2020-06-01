package com.anibalbastias.coolmovies.feature.movies.data.repository

import com.anibalbastias.coolmovies.feature.movies.data.mapper.*
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.MoviesRetrofitService
import com.anibalbastias.coolmovies.feature.movies.domain.repository.DatabaseRepository
import com.anibalbastias.coolmovies.feature.movies.factory.ConfigurationFactory
import com.anibalbastias.coolmovies.feature.movies.factory.MoviesDetailsFactory
import com.anibalbastias.coolmovies.feature.movies.factory.MoviesListFactory
import com.anibalbastias.coolmovies.library.testutils.foundation.RandomFactory
import com.anibalbastias.coolmovies.library.testutils.foundation.RandomFactory.generateHashMapString
import com.anibalbastias.coolmovies.library.testutils.foundation.RandomFactory.generateInt
import com.anibalbastias.coolmovies.library.testutils.foundation.RandomFactory.generateString
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Test

class RemoteRepositoryImplTest {

    @MockK
    internal lateinit var mockService: MoviesRetrofitService

    @MockK
    internal lateinit var configurationMapper: ConfigurationMapper

    @MockK
    internal lateinit var discoverMoviesMapper: DiscoverMoviesMapper

    @MockK
    internal lateinit var movieDetailsMapper: MovieDetailsMapper

    @MockK
    internal lateinit var movieCreditsMapper: MovieCreditsMapper

    @MockK
    internal lateinit var movieRecommendationsMapper: MovieRecommendationsMapper

    @MockK
    internal lateinit var databaseRepository: DatabaseRepository

    private lateinit var cut: RemoteRepositoryImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        cut = RemoteRepositoryImpl(
            mockService, configurationMapper, discoverMoviesMapper, movieDetailsMapper,
            movieCreditsMapper, movieRecommendationsMapper, databaseRepository
        )
    }

    @Test
    fun `getConfiguration fetches RemoteConfiguration and maps to RemoteModel`() {
        // given
        coEvery {
            mockService.getConfigurationAsync()
        } returns ConfigurationFactory.makeRemoteConfiguration()
    }

    @Test
    fun `getConfiguration returns null if response is null`() {
        // given
        coEvery {
            mockService.getConfigurationAsync()
        } returns null
    }

    @Test
    fun `discoverMovies fetches RemoteDiscoverMovies and maps to RemoteModel`() {
        // given
        val map = generateHashMapString()
        val page = generateInt()
        coEvery {
            mockService.discoverMoviesAsync(map)
        } returns MoviesListFactory.makeRemoteDiscoverMovies()
    }
}
