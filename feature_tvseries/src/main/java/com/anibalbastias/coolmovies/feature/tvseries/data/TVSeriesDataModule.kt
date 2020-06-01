package com.anibalbastias.coolmovies.feature.tvseries.data

import com.anibalbastias.coolmovies.feature.tvseries.MODULE_NAME
import com.anibalbastias.coolmovies.feature.tvseries.data.repository.AlbumRepositoryImpl
import com.anibalbastias.coolmovies.feature.tvseries.data.retrofit.service.AlbumRetrofitService
import com.anibalbastias.coolmovies.feature.tvseries.domain.repository.AlbumRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton
import retrofit2.Retrofit

internal val dataModule = Kodein.Module("${MODULE_NAME}DataModule") {

    bind<AlbumRepository>() with singleton { AlbumRepositoryImpl(instance()) }

    bind() from singleton { instance<Retrofit>().create(AlbumRetrofitService::class.java) }
}
