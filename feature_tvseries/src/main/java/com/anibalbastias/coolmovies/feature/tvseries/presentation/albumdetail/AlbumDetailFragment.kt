package com.anibalbastias.coolmovies.feature.tvseries.presentation.albumdetail

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import coil.api.load
import com.anibalbastias.coolmovies.feature.tvseries.R
import com.anibalbastias.coolmovies.library.base.presentation.extension.observe
import com.anibalbastias.coolmovies.library.base.presentation.fragment.BaseContainerFragment
import com.pawegio.kandroid.visible
import kotlinx.android.synthetic.main.fragment_album_detail.*
import org.kodein.di.generic.instance

internal class AlbumDetailFragment : BaseContainerFragment() {

    private val viewModel: AlbumDetailViewModel by instance()

    override val layoutResourceId = R.layout.fragment_album_detail

    private val stateObserver = Observer<AlbumDetailViewModel.ViewState> {
        progressBar.visible = it.isLoading

        nameTextView.text = it.albumName
        nameTextView.visible = it.albumName.isNotBlank()

        artistTextView.text = it.artistName
        artistTextView.visible = it.artistName.isNotBlank()

        errorAnimation.visible = it.isError

        val imageSize = 800

        coverImageView.load(it.coverImageUrl) {
            size(imageSize, imageSize)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe(viewModel.stateLiveData, stateObserver)
        viewModel.loadData()
    }
}
