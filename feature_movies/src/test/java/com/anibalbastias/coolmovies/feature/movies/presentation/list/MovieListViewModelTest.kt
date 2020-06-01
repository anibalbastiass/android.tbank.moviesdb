package com.anibalbastias.coolmovies.feature.movies.presentation.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.anibalbastias.coolmovies.feature.movies.domain.usecase.GetConfigurationUseCase
import com.anibalbastias.coolmovies.feature.movies.domain.usecase.GetDiscoverMoviesUseCase
import com.anibalbastias.coolmovies.feature.movies.factory.ConfigurationFactory
import com.anibalbastias.coolmovies.feature.movies.presentation.mapper.UiDiscoverMoviesMapper
import com.anibalbastias.coolmovies.feature.movies.presentation.viewmodel.MovieListViewModel
import com.anibalbastias.coolmovies.feature.movies.presentation.viewstate.MovieDetailsViewState
import com.anibalbastias.coolmovies.feature.movies.presentation.viewstate.MovieListViewState
import com.anibalbastias.coolmovies.library.base.presentation.navigation.NavManager
import com.anibalbastias.coolmovies.library.testutils.CoroutineRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MovieListViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutineRule()

    @get:Rule
    var rule = InstantTaskExecutorRule()

    @MockK
    internal lateinit var uiDiscoverMoviesMapper: UiDiscoverMoviesMapper
    @MockK
    internal lateinit var getConfigurationUseCase: GetConfigurationUseCase
    @MockK
    internal lateinit var getDiscoverMoviesUseCase: GetDiscoverMoviesUseCase

    @MockK(relaxed = true)
    internal lateinit var mockNavManager: NavManager

    private lateinit var cut: MovieListViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        cut =
            MovieListViewModel(
                uiDiscoverMoviesMapper,
                getConfigurationUseCase,
                getDiscoverMoviesUseCase
            )
    }

    @Test
    fun `verify state when GetConfigurationUseCase returns DomainConfiguration`() {
        // given
        val configuration = ConfigurationFactory.makeDomainConfiguration()
        coEvery { getConfigurationUseCase.execute() } returns ConfigurationFactory.makeDomainConfiguration()
    }

//    @Test
//    fun `verify state when GetConfigurationUseCase returns DomainConfiguration`() {
//        // given
//        val configuration = ConfigurationFactory.makeDomainConfiguration()
//        coEvery { getConfigurationUseCase.execute() } returns ConfigurationFactory.makeDomainConfiguration()
//
//        // when
//        cut.loadData()
//
//        // then
//        cut.stateLiveData.value shouldBeEqualTo MovieListViewState(
//            isLoading = false,
//            isError = true,
//            movies = listOf()
//        )
//    }


}
