package com.anibalbastias.coolmovies.feature.movies.data

import androidx.room.Room
import com.anibalbastias.coolmovies.app.CoolMoviesApplication
import com.anibalbastias.coolmovies.feature.movies.MODULE_NAME
import com.anibalbastias.coolmovies.feature.movies.data.mapper.*
import com.anibalbastias.coolmovies.feature.movies.data.repository.RemoteRepositoryImpl
import com.anibalbastias.coolmovies.feature.movies.data.retrofit.service.MoviesRetrofitService
import com.anibalbastias.coolmovies.feature.movies.data.room.Constants
import com.anibalbastias.coolmovies.feature.movies.data.room.MoviesDatabase
import com.anibalbastias.coolmovies.feature.movies.domain.repository.MoviesRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

internal val dataModule = Kodein.Module("${MODULE_NAME}DataModule") {

    bind() from singleton {
        Room.databaseBuilder(
            CoolMoviesApplication.appContext,
            MoviesDatabase::class.java,
            Constants.DATABASE_NAME
        ).allowMainThreadQueries().build()
    }

    bind<MoviesRepository>() with singleton {
        RemoteRepositoryImpl(
            instance(),
            instance(),
            instance(),
            instance(),
            instance(),
            instance(),
            instance()
        )
    }

    bind() from singleton { instance<Retrofit>().create(MoviesRetrofitService::class.java) }

    bind() from singleton { ConfigurationMapper() }

    bind() from singleton { DiscoverMoviesMapper() }

    bind() from singleton { MovieDetailsMapper() }

    bind() from singleton { MovieCreditsMapper() }

    bind() from singleton { MovieRecommendationsMapper() }

}
