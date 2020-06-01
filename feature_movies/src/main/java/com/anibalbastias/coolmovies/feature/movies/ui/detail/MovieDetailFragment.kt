package com.anibalbastias.coolmovies.feature.movies.ui.detail

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.anibalbastias.coolmovies.feature.movies.R
import com.anibalbastias.coolmovies.feature.movies.databinding.FragmentMovieDetailBinding
import com.anibalbastias.coolmovies.feature.movies.presentation.model.details.credits.UiMovieCast
import com.anibalbastias.coolmovies.feature.movies.presentation.model.details.recommendations.UiMovieRecommendationsResults
import com.anibalbastias.coolmovies.feature.movies.presentation.viewmodel.MovieDetailViewModel
import com.anibalbastias.coolmovies.feature.movies.presentation.viewstate.MovieDetailsViewState
import com.anibalbastias.coolmovies.feature.movies.ui.MoviesNavigator
import com.anibalbastias.coolmovies.feature.movies.ui.detail.adapter.CreditAdapter
import com.anibalbastias.coolmovies.feature.movies.ui.detail.adapter.RecommendationAdapter
import com.anibalbastias.coolmovies.library.base.presentation.extension.observe
import com.anibalbastias.coolmovies.library.base.presentation.fragment.BaseContainerFragment
import com.anibalbastias.coolmovies.library.base.ui.adapter.base.BaseBindClickHandler
import com.anibalbastias.coolmovies.library.base.ui.extension.applyFontForToolbarTitle
import com.anibalbastias.coolmovies.library.base.ui.extension.runLayoutAnimation
import com.anibalbastias.coolmovies.library.base.ui.extension.setArrowUpToolbar
import com.pawegio.kandroid.visible
import kotlinx.android.synthetic.main.fragment_movie_detail_content.*
import org.kodein.di.generic.instance

internal class MovieDetailFragment : BaseContainerFragment() {

    override val layoutResourceId = R.layout.fragment_movie_detail

    private val viewModel: MovieDetailViewModel by instance()
    private lateinit var binding: FragmentMovieDetailBinding
    private val args: MovieDetailFragmentArgs by navArgs()

    private val creditAdapter: CreditAdapter by instance()
    private val recommendationAdapter: RecommendationAdapter by instance()
    private val movieNavigator: MoviesNavigator by instance()

    private val stateObserver = Observer<MovieDetailsViewState> {
        progressBar?.visible = it.isLoading
        cvContainer?.visible = !it.isLoading

        binding.movieDetails = it.movieDetails
        binding.movieCredits = it.movieCredits
        binding.movieRecommendations = it.movieRecommendations

        creditAdapter.items =
            (it.movieCredits?.cast as? MutableList<UiMovieCast?>) ?: mutableListOf()
        creditAdapter.notifyDataSetChanged()

        recommendationAdapter.items =
            (it.movieRecommendations?.results as? MutableList<UiMovieRecommendationsResults?>)
                ?: mutableListOf()
        recommendationAdapter.notifyDataSetChanged()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = DataBindingUtil.bind<ViewDataBinding>(view) as FragmentMovieDetailBinding
        binding.lifecycleOwner = this

        viewModel.movieId = "${args.movieId}"
        observe(viewModel.stateLiveData, stateObserver)
        viewModel.loadData()

        initToolbar()
        setAdapters()
    }

    private fun setAdapters() {
        rvCredits.apply {
            setHasFixedSize(true)
            adapter = creditAdapter
            runLayoutAnimation()
        }

        rvRecommendations.apply {
            setHasFixedSize(true)
            adapter = recommendationAdapter
            runLayoutAnimation()
        }

        recommendationAdapter.clickHandler = object : BaseBindClickHandler<UiMovieRecommendationsResults> {
            override fun onClickView(view: View, item: UiMovieRecommendationsResults) {
                movieNavigator.navigateToRecommendedMovieDetails(item)
            }
        }
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
