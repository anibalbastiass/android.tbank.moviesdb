package com.anibalbastias.coolmovies.library.base

import com.anibalbastias.coolmovies.library.base.presentation.navigation.NavManager
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

internal const val MODULE_NAME = "Base"

val baseModule = Kodein.Module("${MODULE_NAME}Module") {

    bind() from singleton { NavManager() }
}
