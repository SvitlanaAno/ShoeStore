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
import com.perlovka.shoeStore.models.UserPreference
import com.perlovka.shoeStore.models.UserStatus
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ShoeList: Fragment() {
    private lateinit var userPreference: UserPreference
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
    //Show SupportActionBar again in onResume() with .show()
    override fun onResume() {
        super.onResume()
            val supportActionBar = (requireActivity() as AppCompatActivity).supportActionBar
            supportActionBar?.show()
    }

    // Inflate menu resource
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.logout_menu, menu)
    }

    @DelicateCoroutinesApi
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        userPreference = UserPreference(requireContext())
        GlobalScope.launch{
            userPreference.saveAuthStatus(UserStatus.UNAUTHENTICATED)
            }
            return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                    || super.onOptionsItemSelected(item)
        }
}
