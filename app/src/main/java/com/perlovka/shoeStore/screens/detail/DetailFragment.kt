package com.perlovka.shoeStore.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.perlovka.shoeStore.R
import com.perlovka.shoeStore.databinding.ShoeDetailBinding
import com.perlovka.shoeStore.databinding.ShoeListBinding

class DetailFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: ShoeDetailBinding = DataBindingUtil.inflate(
            inflater, R.layout.shoe_detail, container, false
        )
        return binding.root
    }
}