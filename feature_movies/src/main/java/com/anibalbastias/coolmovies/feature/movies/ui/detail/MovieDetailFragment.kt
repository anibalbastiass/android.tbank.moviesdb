package com.anibalbastias.coolmovies.feature.movies.ui.detail

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.anibalbastias.coolmovies.feature.movies.R
import com.anibalbastias.coolmovies.feature.movies.databinding.FragmentMovieDetailBinding
import com.anibalbastias.coolmovies.feature.movies.presentation.viewmodel.MovieDetailViewModel
import com.anibalbastias.coolmovies.feature.movies.presentation.viewstate.MovieDetailsViewState
import com.anibalbastias.coolmovies.library.base.presentation.extension.observe
import com.anibalbastias.coolmovies.library.base.presentation.fragment.BaseContainerFragment
import com.anibalbastias.coolmovies.library.base.ui.extension.applyFontForToolbarTitle
import com.anibalbastias.coolmovies.library.base.ui.extension.setArrowUpToolbar
import com.pawegio.kandroid.visible
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import kotlinx.android.synthetic.main.fragment_movie_detail_content.*
import org.kodein.di.generic.instance

internal class MovieDetailFragment : BaseContainerFragment() {

    override val layoutResourceId = R.layout.fragment_movie_detail

    private val viewModel: MovieDetailViewModel by instance()
    private lateinit var binding: FragmentMovieDetailBinding
    private val args: MovieDetailFragmentArgs by navArgs()

    private val stateObserver = Observer<MovieDetailsViewState> {
        progressBar?.visible = it.isLoading
        cvContainer?.visible = !it.isLoading

        binding.movieDetails = it.movieDetails
        binding.movieCredits = it.movieCredits
        binding.movieRecommendations = it.movieRecommendations
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = DataBindingUtil.bind<ViewDataBinding>(view) as FragmentMovieDetailBinding
        binding.lifecycleOwner = this

        viewModel.movieId = "${args.movieItem.id}"
        observe(viewModel.stateLiveData, stateObserver)
        viewModel.loadData()

        initToolbar()
    }

    private fun initToolbar() {
        binding.toolbar.run {
            applyFontForToolbarTitle(requireActivity())
            setArrowUpToolbar(requireActivity())
            setNavigationOnClickListener {
                activity?.onBackPressed()
            }
        }
    }
}
