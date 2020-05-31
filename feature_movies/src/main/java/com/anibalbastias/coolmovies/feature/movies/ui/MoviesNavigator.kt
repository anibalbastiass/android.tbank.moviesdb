package com.anibalbastias.coolmovies.feature.movies.ui

import com.anibalbastias.coolmovies.feature.movies.presentation.model.UiMovieItem
import com.anibalbastias.coolmovies.feature.movies.ui.list.MovieListFragmentDirections
import com.anibalbastias.coolmovies.library.base.presentation.navigation.NavManager

class MoviesNavigator(private val navManager: NavManager) {

    fun navigateToMovieDetails(item: UiMovieItem) {
        /*val navDirections =
            MovieListFragmentDirections.actionAlbumListToAlbumDetail(
                artistName,
                albumName,
                mbId
            )
        navManager.navigate(navDirections)*/
    }

}