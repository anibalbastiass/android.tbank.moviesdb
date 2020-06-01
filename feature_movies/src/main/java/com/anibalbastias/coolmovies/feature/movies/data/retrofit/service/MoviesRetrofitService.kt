package com.anibalbastias.coolmovies.feature.movies.data.retrofit.service

import com.anibalbastias.coolmovies.feature.movies.data.model.RemoteConfiguration
import com.anibalbastias.coolmovies.feature.movies.data.model.RemoteDiscoverMovies
import com.anibalbastias.coolmovies.feature.movies.data.model.details.RemoteMovieDetails
import com.anibalbastias.coolmovies.feature.movies.data.model.details.credits.RemoteMovieCredits
import com.anibalbastias.coolmovies.feature.movies.data.model.details.recommendations.RemoteMovieRecommendations
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.CONFIGURATION
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.CREDITS
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.DISCOVER
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.MOVIE
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.MOVIE_PATH
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.Constants.RECOMMENDATIONS
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

internal interface MoviesRetrofitService {

    @GET(CONFIGURATION)
    suspend fun getConfigurationAsync(): RemoteConfiguration?

    @GET("$DISCOVER/$MOVIE")
    suspend fun discoverMoviesAsync(@QueryMap map: HashMap<String, String>): RemoteDiscoverMovies?

    @GET("$MOVIE/{$MOVIE_PATH}")
    suspend fun getMovieDetailsAsync(
        @Path(MOVIE_PATH) movieId: String,
        @QueryMap map: HashMap<String, String>
    ): RemoteMovieDetails?

    @GET("$MOVIE/{$MOVIE_PATH}/$CREDITS")
    suspend fun getMovieDetailsCreditsAsync(@Path(MOVIE_PATH) movieId: String): RemoteMovieCredits?

    @GET("$MOVIE/{$MOVIE_PATH}/$RECOMMENDATIONS")
    suspend fun getMovieDetailsRecommendationsAsync(@Path(MOVIE_PATH) movieId: String): RemoteMovieRecommendations?

}
