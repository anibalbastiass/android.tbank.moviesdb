package com.anibalbastias.coolmovies.feature.tvseries.presentation

import androidx.fragment.app.Fragment
import coil.ImageLoader
import com.anibalbastias.coolmovies.feature.tvseries.MODULE_NAME
import com.anibalbastias.coolmovies.feature.tvseries.presentation.albumdetail.AlbumDetailViewModel
import com.anibalbastias.coolmovies.feature.tvseries.presentation.albumlist.AlbumListViewModel
import com.anibalbastias.coolmovies.feature.tvseries.presentation.albumlist.recyclerview.AlbumAdapter
import com.anibalbastias.coolmovies.library.base.di.KotlinViewModelProvider
import org.kodein.di.Kodein
import org.kodein.di.android.x.AndroidLifecycleScope
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.scoped
import org.kodein.di.generic.singleton

internal val presentationModule = Kodein.Module("${MODULE_NAME}PresentationModule") {

    // AlbumList
    bind<AlbumListViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        KotlinViewModelProvider.of(context) { AlbumListViewModel(instance(), instance()) }
    }

    bind() from singleton { AlbumAdapter() }

//    bind() from singleton { ImageLoader(instance()) }

    // AlbumDetails
    bind<AlbumDetailViewModel>() with scoped<Fragment>(AndroidLifecycleScope).singleton {
        KotlinViewModelProvider.of(context) { AlbumDetailViewModel(instance(), instance()) }
    }
}