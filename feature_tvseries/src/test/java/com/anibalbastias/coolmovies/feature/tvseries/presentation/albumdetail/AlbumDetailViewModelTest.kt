package com.anibalbastias.coolmovies.feature.tvseries.presentation.albumdetail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.anibalbastias.coolmovies.feature.tvseries.domain.usecase.GetAlbumUseCase
import com.anibalbastias.coolmovies.feature.tvseries.presentation.albumdetail.AlbumDetailViewModel.ViewState
import com.anibalbastias.coolmovies.library.testutils.CoroutineRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.amshove.kluent.shouldBeEqualTo
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class AlbumDetailViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutineRule()

    @get:Rule
    var rule = InstantTaskExecutorRule()

    @MockK
    internal lateinit var mockGetAlbumUseCase: GetAlbumUseCase

    @MockK
    internal lateinit var mockAlbumDetailFragmentArgs: AlbumDetailFragmentArgs

    private lateinit var cut: AlbumDetailViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        cut = AlbumDetailViewModel(
            mockGetAlbumUseCase,
            mockAlbumDetailFragmentArgs
        )
    }

    @Test
    fun `verify state when GetAlbumUseCase return null`() {
        // given
        val albumName = "albumName"
        val artistName = "artistName"
        val mbId = "123"

        every { mockAlbumDetailFragmentArgs.albumName } returns albumName
        every { mockAlbumDetailFragmentArgs.artistName } returns artistName
        every { mockAlbumDetailFragmentArgs.mbId } returns mbId
        coEvery { mockGetAlbumUseCase.execute(artistName, albumName, mbId) } returns null

        // when
        cut.loadData()

        // then
        cut.stateLiveData.value shouldBeEqualTo ViewState(
            isLoading = false,
            isError = true,
            artistName = "",
            albumName = "",
            coverImageUrl = ""
        )
    }
}
