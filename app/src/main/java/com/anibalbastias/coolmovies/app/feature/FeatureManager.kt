package com.anibalbastias.coolmovies.app.feature

import com.anibalbastias.coolmovies.BuildConfig

// Dynamic Feature modules require reversed dependency (dynamic feature module depends on app module)
// This means we have to use reflection to access module content
// See: https://medium.com/mindorks/dynamic-feature-modules-the-future-4bee124c0f1
@Suppress("detekt.UnsafeCast")
object FeatureManager {

    private const val featurePackagePrefix = "com.anibalbastias.coolmovies.feature"

    val kodeinModules = BuildConfig.FEATURE_MODULE_NAMES
        .map { "$featurePackagePrefix.$it.FeatureKodeinModule" }
        .map {
            try {
                Class.forName(it).kotlin.objectInstance as KodeinModuleProvider
            } catch (e: ClassNotFoundException) {
                throw ClassNotFoundException("Kodein module class not found $it")
            }
        }
        .map { it.kodeinModule }
}
