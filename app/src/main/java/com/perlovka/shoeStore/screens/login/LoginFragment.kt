package com.perlovka.shoeStore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.perlovka.shoeStore.R
import com.perlovka.shoeStore.databinding.LoginFragmentBinding
import androidx.appcompat.app.AppCompatActivity




class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: LoginFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.login_fragment, container, false
        )

        // Set action when button is pressed
        binding.loginButton.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
        }
            return binding.root
        }
    //hide the SupportActionBar in onResume() with .hide() method
    override fun onResume() {
        super.onResume()
        val supportActionBar: ActionBar? = (requireActivity() as AppCompatActivity).supportActionBar
        supportActionBar?.hide()
    }
}