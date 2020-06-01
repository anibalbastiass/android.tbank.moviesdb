package com.anibalbastias.coolmovies.feature.favourite

import com.anibalbastias.coolmovies.app.feature.KodeinModuleProvider
import com.anibalbastias.coolmovies.feature.favourite.data.dataModule
import com.anibalbastias.coolmovies.feature.favourite.domain.domainModule
import com.anibalbastias.coolmovies.feature.favourite.presentation.presentationModule
import org.kodein.di.Kodein

internal const val MODULE_NAME = "Favourite"

object FeatureKodeinModule : KodeinModuleProvider {

    override val kodeinModule = Kodein.Module("${MODULE_NAME}Module") {
        import(presentationModule)
        import(domainModule)
        import(dataModule)
    }
}
