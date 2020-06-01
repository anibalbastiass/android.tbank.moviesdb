package com.anibalbastias.coolmovies.feature.movies.presentation

import androidx.fragment.app.Fragment
import com.anibalbastias.coolmovies.feature.movies.MODULE_NAME
import com.anibalbastias.coolmovies.feature.movies.presentation.mapper.UiDiscoverMoviesMapper
import com.anibalbastias.coolmovies.feature.movies.presentation.mapper.UiMovieCreditsMapper
import com.anibalbastias.coolmovies.feature.movies.presentation.mapper.UiMovieDetailsMapper
import com.anibalbastias.coolmovies.feature.movies.presentation.mapper.UiMovieRecommendationsMapper
import com.anibalbastias.coolmovies.feature.movies.presentation.model.UiMovieItem
import com.anibalbastias.coolmovies.feature.movies.presentation.viewmodel.MovieDetailViewModel
import com.anibalbastias.coolmovies.feature.movies.presentation.viewmodel.MovieListViewModel
import com.anibalbastias.coolmovies.library.base.di.KotlinViewModelProvider
import com.anibalbastias.coolmovies.library.base.presentation.viewmodel.PaginationViewModel
import org.kodein.di.Kodein
import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

internal val presentationModule = Kodein.Module("${MODULE_NAME}PresentationModule") {

    // Movie List
    bind<MovieListViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        KotlinViewModelProvider.of(context) {
            MovieListViewModel(
                instance(),
                instance(),
                instance()
            )
        }
    }

    // Movie Details
    bind<MovieDetailViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        KotlinViewModelProvider.of(context) {
            MovieDetailViewModel(
                instance(),
                instance(),
                instance(),
                instance(),
                instance(),
                instance(),
                instance()
            )
        }
    }

    bind() from singleton { PaginationViewModel<UiMovieItem>() }

    bind() from singleton { UiDiscoverMoviesMapper() }

    bind() from singleton { UiMovieDetailsMapper() }

    bind() from singleton { UiMovieCreditsMapper() }

    bind() from singleton { UiMovieRecommendationsMapper() }

}