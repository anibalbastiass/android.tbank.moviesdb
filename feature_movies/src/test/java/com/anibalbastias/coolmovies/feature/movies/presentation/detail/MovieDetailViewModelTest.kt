package com.anibalbastias.coolmovies.feature.movies.presentation.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.anibalbastias.coolmovies.feature.movies.domain.usecase.GetConfigurationUseCase
import com.anibalbastias.coolmovies.feature.movies.domain.usecase.GetMovieCreditsUseCase
import com.anibalbastias.coolmovies.feature.movies.domain.usecase.GetMovieDetailsUseCase
import com.anibalbastias.coolmovies.feature.movies.domain.usecase.GetMovieRecommendationsUseCase
import com.anibalbastias.coolmovies.feature.movies.factory.ConfigurationFactory
import com.anibalbastias.coolmovies.feature.movies.presentation.mapper.UiMovieCreditsMapper
import com.anibalbastias.coolmovies.feature.movies.presentation.mapper.UiMovieDetailsMapper
import com.anibalbastias.coolmovies.feature.movies.presentation.mapper.UiMovieRecommendationsMapper
import com.anibalbastias.coolmovies.feature.movies.presentation.viewmodel.MovieDetailViewModel
import com.anibalbastias.coolmovies.library.testutils.CoroutineRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MovieDetailViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutineRule()

    @get:Rule
    var rule = InstantTaskExecutorRule()

    @MockK
    internal lateinit var uiMovieDetailsMapper: UiMovieDetailsMapper
    @MockK
    internal lateinit var uiMovieCreditsMapper: UiMovieCreditsMapper
    @MockK
    internal lateinit var uiMovieRecommendationsMapper: UiMovieRecommendationsMapper
    @MockK
    internal lateinit var getConfigurationUseCase: GetConfigurationUseCase
    @MockK
    internal lateinit var getMovieDetailsUseCase: GetMovieDetailsUseCase
    @MockK
    internal lateinit var getMovieCreditsUseCase: GetMovieCreditsUseCase
    @MockK
    internal lateinit var getMovieRecommendationsUseCase: GetMovieRecommendationsUseCase

    private lateinit var cut: MovieDetailViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        cut =
            MovieDetailViewModel(
                uiMovieDetailsMapper,
                uiMovieCreditsMapper,
                uiMovieRecommendationsMapper,
                getConfigurationUseCase,
                getMovieDetailsUseCase,
                getMovieCreditsUseCase,
                getMovieRecommendationsUseCase
            )
    }

    @Test
    fun `verify state when GetConfigurationUseCase returns DomainConfiguration`() {
        // given
        coEvery { getConfigurationUseCase.execute() } returns ConfigurationFactory.makeDomainConfiguration()
    }

//    @Test
//    fun `verify state when GetConfigurationUseCase returns DomainConfiguration`() {
//        // given
//        coEvery { getConfigurationUseCase.execute() } returns ConfigurationFactory.makeDomainConfiguration()
//
//        // when
//        cut.loadData()
//
//        // then
//        cut.stateLiveData.value shouldBeEqualTo MovieDetailsViewState(
//            isLoading = false,
//            isError = true,
//            movieDetails = null
//        )
//    }
}
