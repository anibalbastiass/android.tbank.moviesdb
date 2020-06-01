package com.anibalbastias.coolmovies.feature.favourite.presentation.favourite

import com.anibalbastias.coolmovies.feature.favourite.R
import com.anibalbastias.coolmovies.library.base.presentation.fragment.BaseContainerFragment
import kotlinx.android.synthetic.main.fragment_favourites.*

class FavouriteFragment : BaseContainerFragment() {

    override val layoutResourceId = R.layout.fragment_favourites

    override fun onResume() {
        super.onResume()
        underConstructionAnimation.playAnimation()
    }
}
