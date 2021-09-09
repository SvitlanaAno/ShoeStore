package com.perlovka.shoeStore.screens.shoeList

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.perlovka.shoeStore.R
import com.perlovka.shoeStore.databinding.ShoeListBinding
import com.perlovka.shoeStore.screens.login.LoginFragmentDirections

class ShoeList: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for fragment
        val binding: ShoeListBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_list, container, false
        )

        // Set action when button is pressed
        binding.fab.setOnClickListener {
            findNavController().navigate(ShoeListDirections.actionShoeListFragmentToDetailFragment())
        }
        setHasOptionsMenu(true)
        return binding.root

    }
    //show SupportActionBar again in onResume() with .show()
    override fun onResume() {
        super.onResume()
            val supportActionBar = (requireActivity() as AppCompatActivity).supportActionBar
            supportActionBar?.show()
    }

    // inflate menu resource
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}
