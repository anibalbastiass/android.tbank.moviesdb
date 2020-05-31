package com.anibalbastias.coolmovies.feature.movies.data.retrofit.service

import com.anibalbastias.coolmovies.feature.movies.data.model.RemoteConfiguration
import com.anibalbastias.coolmovies.feature.movies.data.model.RemoteDiscoverMovies
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.CONFIGURATION
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.DISCOVER
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.MOVIE
import retrofit2.http.GET
import retrofit2.http.QueryMap

internal interface MoviesRetrofitService {

    @GET(CONFIGURATION)
    suspend fun getConfigurationAsync(): RemoteConfiguration?

    @GET("$DISCOVER/$MOVIE")
    suspend fun discoverMoviesAsync(@QueryMap map: HashMap<String, String>): RemoteDiscoverMovies?

}
