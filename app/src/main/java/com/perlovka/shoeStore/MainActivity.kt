package com.perlovka.shoeStore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.perlovka.shoeStore.databinding.ActivityMainBinding
import com.perlovka.shoeStore.models.UserPreference

class MainActivity : AppCompatActivity() {
    lateinit var userPreference: UserPreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
        val view = binding.root
        setContentView(view)


        //Set of ids for all top level destinations.
        val topLevelDestinations = mutableSetOf<Int>()
        topLevelDestinations.add(R.id.loginFragment)
        topLevelDestinations.add(R.id.welcomeFragment)
        topLevelDestinations.add(R.id.shoeListFragment)

         // Connect the navigation controller to the NavHostFragment
        val appBarConfiguration = AppBarConfiguration.Builder(topLevelDestinations).build()
        userPreference = UserPreference(this)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }
}