package com.anibalbastias.coolmovies.feature.tvseries.domain

import com.anibalbastias.coolmovies.feature.tvseries.MODULE_NAME
import com.anibalbastias.coolmovies.feature.tvseries.domain.usecase.GetAlbumUseCase
import com.anibalbastias.coolmovies.feature.tvseries.domain.usecase.GetAlbumListUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

internal val domainModule = Kodein.Module("${MODULE_NAME}DomainModule") {

    bind() from singleton { GetAlbumListUseCase(instance()) }

    bind() from singleton { GetAlbumUseCase(instance()) }
}
