package com.anibalbastias.coolmovies.feature.movies.presentation.viewstate

import com.anibalbastias.coolmovies.feature.movies.presentation.model.UiMovieItem
import com.anibalbastias.coolmovies.library.base.presentation.viewmodel.BaseViewState

data class MovieListViewState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val movies: List<UiMovieItem> = listOf()
) : BaseViewState