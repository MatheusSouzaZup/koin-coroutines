package com.example.koincorountines.ui

import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.plusAssign
import androidx.navigation.ui.setupWithNavController
import com.example.koincorountines.R
import com.example.koincorountines.custom.KeepStateNavigator
import com.example.koincorountines.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    lateinit var navController: NavController

    override val activityLayout: Int = R.layout.activity_main

    override fun init() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)!!
        val navigator =
            KeepStateNavigator(this, navHostFragment.childFragmentManager, R.id.nav_host_fragment)
        navController.navigatorProvider += navigator
        navController.setGraph(R.navigation.nav_graph)
        bind.bottomNavigation.setupWithNavController(navController)

    }
}
