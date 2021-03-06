package com.anibalbastias.coolmovies.feature.tvseries.presentation.albumlist

import androidx.lifecycle.viewModelScope
import com.anibalbastias.coolmovies.feature.tvseries.domain.model.AlbumDomainModel
import com.anibalbastias.coolmovies.feature.tvseries.domain.usecase.GetAlbumListUseCase
import com.anibalbastias.coolmovies.library.base.presentation.navigation.NavManager
import com.anibalbastias.coolmovies.library.base.presentation.viewmodel.BaseAction
import com.anibalbastias.coolmovies.library.base.presentation.viewmodel.BaseViewModel
import com.anibalbastias.coolmovies.library.base.presentation.viewmodel.BaseViewState
import kotlinx.coroutines.launch

internal class AlbumListViewModel(
    private val navManager: NavManager,
    private val getAlbumListUseCase: GetAlbumListUseCase
) : BaseViewModel<AlbumListViewModel.ViewState, AlbumListViewModel.Action>(ViewState()) {

    override fun onLoadData() {
        getAlbumList()
    }

    override fun onReduceState(viewAction: Action) = when (viewAction) {
        is Action.AlbumListLoadingSuccess -> state.copy(
            isLoading = false,
            isError = false,
            albums = viewAction.albums
        )
        is Action.AlbumListLoadingFailure -> state.copy(
            isLoading = false,
            isError = true,
            albums = listOf()
        )
    }

    private fun getAlbumList() {
        viewModelScope.launch {
            getAlbumListUseCase.execute().also {
                if (it.isNotEmpty()) {
                    sendAction(Action.AlbumListLoadingSuccess(it))
                } else {
                    sendAction(Action.AlbumListLoadingFailure)
                }
            }
        }
    }

    fun navigateToAlbumDetails(artistName: String, albumName: String, mbId: String?) {
        val navDirections = AlbumListFragmentDirections.actionAlbumListToAlbumDetail(artistName, albumName, mbId)
        navManager.navigate(navDirections)
    }

    internal data class ViewState(
        val isLoading: Boolean = true,
        val isError: Boolean = false,
        val albums: List<AlbumDomainModel> = listOf()
    ) : BaseViewState

    internal sealed class Action : BaseAction {
        class AlbumListLoadingSuccess(val albums: List<AlbumDomainModel>) : Action()
        object AlbumListLoadingFailure : Action()
    }
}
