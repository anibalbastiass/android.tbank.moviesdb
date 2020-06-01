package com.anibalbastias.coolmovies.feature.profile.presentation.profile

import com.anibalbastias.coolmovies.feature.profile.R
import com.anibalbastias.coolmovies.library.base.presentation.fragment.BaseContainerFragment
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : BaseContainerFragment() {

    override val layoutResourceId = R.layout.fragment_profile

    override fun onResume() {
        super.onResume()
        underConstructionAnimation.playAnimation()
    }
}
