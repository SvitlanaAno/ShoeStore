package com.perlovka.shoeStore.screens.shoeList

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.perlovka.shoeStore.R
import com.perlovka.shoeStore.databinding.ShoeItemCardBinding
import com.perlovka.shoeStore.databinding.ShoeListBinding
import com.perlovka.shoeStore.models.Shoes
import com.perlovka.shoeStore.models.UserPreference
import com.perlovka.shoeStore.models.UserStatus
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch



class ShoeList: Fragment() {
    private lateinit var userPreference: UserPreference
    private lateinit var binding: ShoeListBinding
    private val model: SharedViewModel by activityViewModels()
    private lateinit var popup: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for fragment
         binding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_list, container, false
        )

        binding.fab.setOnClickListener {
            findNavController().navigate(ShoeListDirections.actionShoeListFragmentToDetailFragment())
        }
        binding.lifecycleOwner = this
        model.shoesList.observe(viewLifecycleOwner, Observer { shoes ->
            Log.i("Shoe List", "Inside shoeList Observe")
            addShoeListView(shoes)
        })
       // Associate menu with this Fragment
        setHasOptionsMenu(true)
        return binding.root

    }
    // Manually generating a view that adds shoe details value in a single cardview
    private fun addShoeListView(shoes: List<Shoes>) {
        val image = listOf(R.drawable.shoe_item, R.drawable.shoe_item2,R.drawable.shoe_item3)
        Log.i("Shoe List", "Inside addShoeListView")
        shoes.forEach {
            val shoeBinding = ShoeItemCardBinding.inflate(LayoutInflater.from(requireContext()), binding.listshopLinear, false)
            with(shoeBinding){
                shoeBinding.shoeItem = it
                shoeBinding.shoeCardImage.setImageResource(image.random())
            }
            binding.listshopLinear.addView(shoeBinding.root)
        }
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
