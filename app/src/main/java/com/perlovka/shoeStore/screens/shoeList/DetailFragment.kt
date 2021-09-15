package com.perlovka.shoeStore.screens.shoeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.perlovka.shoeStore.R
import com.perlovka.shoeStore.databinding.ShoeDetailBinding
import com.perlovka.shoeStore.models.Shoes

class DetailFragment : Fragment() {
    private val model: SharedViewModel by activityViewModels()
    private lateinit var binding: ShoeDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_detail, container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = this
        binding.shoe = Shoes()
        binding.save.setOnClickListener { view ->

            //Navigate back to the shoe list screen and add a new Shoe to the Shared View Model.
            model.add(binding.shoe)
            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToShoeListFragment())
        }

        binding.cancel.setOnClickListener {

            //Navigate back to the shoe list screen without any action
            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToShoeListFragment())
        }
    }


}