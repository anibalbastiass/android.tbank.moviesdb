package com.anibalbastias.coolmovies.feature.movies.presentation.action

import com.anibalbastias.coolmovies.feature.movies.domain.model.DomainMovieItem
import com.anibalbastias.coolmovies.library.base.presentation.viewmodel.BaseAction

sealed class MovieListAction : BaseAction {
    class MovieListLoadingSuccess(val movies: List<DomainMovieItem>) : MovieListAction()
    object MovieListLoadingFailure : MovieListAction()
}