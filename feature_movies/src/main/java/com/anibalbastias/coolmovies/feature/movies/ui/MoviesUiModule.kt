package com.anibalbastias.coolmovies.feature.movies.ui

import coil.ImageLoader
import com.anibalbastias.coolmovies.feature.movies.MODULE_NAME
import com.anibalbastias.coolmovies.feature.movies.presentation.detail.adapter.CreditAdapter
import com.anibalbastias.coolmovies.feature.movies.presentation.detail.adapter.RecommendationAdapter
import com.anibalbastias.coolmovies.feature.movies.presentation.list.adapter.MovieAdapter
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

internal val uiModule = Kodein.Module("${MODULE_NAME}UiModule") {

    bind() from singleton { MovieAdapter() }

    bind() from singleton { CreditAdapter() }

    bind() from singleton { RecommendationAdapter() }

    bind() from singleton { ImageLoader(instance()) }

    bind() from singleton { MoviesNavigator(instance()) }

}