package com.anibalbastias.coolmovies.feature.movies.ui

import coil.ImageLoader
import com.anibalbastias.coolmovies.feature.movies.MODULE_NAME
import com.anibalbastias.coolmovies.feature.movies.ui.list.recyclerview.MovieAdapter
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

internal val uiModule = Kodein.Module("${MODULE_NAME}UiModule") {

    bind() from singleton { MovieAdapter() }

    bind() from singleton { ImageLoader(instance()) }

    bind() from singleton { MoviesNavigator(instance()) }

}