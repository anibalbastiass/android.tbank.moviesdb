package com.anibalbastias.coolmovies.feature.movies

import com.anibalbastias.coolmovies.app.feature.KodeinModuleProvider
import com.anibalbastias.coolmovies.feature.movies.data.dataModule
import com.anibalbastias.coolmovies.feature.movies.domain.domainModule
import com.anibalbastias.coolmovies.feature.movies.presentation.presentationModule
import com.anibalbastias.coolmovies.feature.movies.ui.uiModule
import org.kodein.di.Kodein

internal const val MODULE_NAME = "Movies"

object FeatureKodeinModule : KodeinModuleProvider {

    override val kodeinModule = Kodein.Module("${MODULE_NAME}Module") {
        import(uiModule)
        import(presentationModule)
        import(domainModule)
        import(dataModule)
    }
}
