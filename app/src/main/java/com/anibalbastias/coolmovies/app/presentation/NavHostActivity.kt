package com.anibalbastias.coolmovies.app.presentation

import android.os.Bundle
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.anibalbastias.coolmovies.R
import com.anibalbastias.coolmovies.library.base.presentation.activity.BaseActivity
import com.anibalbastias.coolmovies.library.base.presentation.navigation.NavManager
import kotlinx.android.synthetic.main.activity_nav_host.*
import org.kodein.di.generic.instance

class NavHostActivity : BaseActivity() {

    override val layoutResId = R.layout.activity_nav_host

    private val navController get() = navHostFragment.findNavController()

    private val navManager: NavManager by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBottomNavigation()
        initNavManager()
    }

    private fun initBottomNavigation() {
        bottomNav.setupWithNavController(navController)
    }

    private fun initNavManager() {
        navManager.setOnNavEvent {
            navController.navigate(it)
        }
    }
}
