package com.anibalbastias.coolmovies.feature.movies.domain.usecase

import com.anibalbastias.coolmovies.feature.movies.data.repository.RemoteRepositoryImpl
import com.anibalbastias.coolmovies.feature.movies.factory.ConfigurationFactory
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
class GetConfigurationUseCaseTest {

    @MockK
    internal lateinit var mockRemoteRepository: RemoteRepositoryImpl

    private lateinit var cut: GetConfigurationUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        cut = GetConfigurationUseCase(mockRemoteRepository)
    }

    @Test
    fun `return configuration`() {
        // given
        val configuration = ConfigurationFactory.makeDomainConfiguration()
        coEvery { mockRemoteRepository.getConfiguration() } returns configuration

        // when
        val result = runBlocking { cut.execute() }

        // then
        result shouldBeEqualTo configuration
    }
}
