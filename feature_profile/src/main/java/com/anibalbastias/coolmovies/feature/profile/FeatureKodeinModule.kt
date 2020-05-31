package com.anibalbastias.coolmovies.feature.profile

import com.anibalbastias.coolmovies.app.feature.KodeinModuleProvider
import com.anibalbastias.coolmovies.feature.profile.data.dataModule
import com.anibalbastias.coolmovies.feature.profile.domain.domainModule
import com.anibalbastias.coolmovies.feature.profile.presentation.presentationModule
import org.kodein.di.Kodein

internal const val MODULE_NAME = "Profile"

object FeatureKodeinModule : KodeinModuleProvider {

    override val kodeinModule = Kodein.Module("${MODULE_NAME}Module") {
        import(presentationModule)
        import(domainModule)
        import(dataModule)
    }
}
