package com.anibalbastias.coolmovies.feature.tvseries

import com.anibalbastias.coolmovies.app.feature.KodeinModuleProvider
import com.anibalbastias.coolmovies.feature.tvseries.data.dataModule
import com.anibalbastias.coolmovies.feature.tvseries.domain.domainModule
import com.anibalbastias.coolmovies.feature.tvseries.presentation.presentationModule
import org.kodein.di.Kodein

internal const val MODULE_NAME = "TVSeries"

object FeatureKodeinModule : KodeinModuleProvider {

    override val kodeinModule = Kodein.Module("${MODULE_NAME}Module") {
        import(presentationModule)
        import(domainModule)
        import(dataModule)
    }
}
