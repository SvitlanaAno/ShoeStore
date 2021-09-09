package com.perlovka.shoeStore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.perlovka.shoeStore.databinding.ActivityMainBinding
import com.perlovka.shoeStore.databinding.ShoeDetailBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        val view = binding.root
        setContentView(view)

      /*  //set of ids for all top level destinations.
        val topLevelDestinations =  mutableSetOf<Int>()
        topLevelDestinations.add(R.id.loginFragment)
        topLevelDestinations.add(R.id.welcomeFragment)
        topLevelDestinations.add(R.id.instructionFragment)
        val appBarConfiguration = AppBarConfiguration.Builder(topLevelDestinations).build()
*/
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.myNavHostFragment) as NavHostFragment
        val navController = navHostFragment.navController
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return navController.navigateUp()
    }
}