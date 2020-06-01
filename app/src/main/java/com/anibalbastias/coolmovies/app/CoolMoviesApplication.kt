package com.anibalbastias.coolmovies.app

import android.content.Context
import com.anibalbastias.coolmovies.BuildConfig
import com.anibalbastias.coolmovies.app.feature.FeatureManager
import com.anibalbastias.coolmovies.app.kodein.FragmentArgsExternalSource
import com.anibalbastias.coolmovies.appModule
import com.anibalbastias.coolmovies.library.base.baseModule
import com.facebook.stetho.Stetho
import com.google.android.play.core.splitcompat.SplitCompatApplication
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import timber.log.Timber


class CoolMoviesApplication : SplitCompatApplication(), KodeinAware {

    companion object {
        lateinit var appContext: Context
    }

    override val kodein = Kodein.lazy {
        import(androidXModule(this@CoolMoviesApplication))
        import(baseModule)
        import(appModule)
        importAll(FeatureManager.kodeinModules)

        externalSources.add(FragmentArgsExternalSource())
    }

    private lateinit var context: Context

    override fun onCreate() {
        super.onCreate()

        context = this
        appContext = this

        initTimber()
        initStetho()
    }

    private fun initStetho() {
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
