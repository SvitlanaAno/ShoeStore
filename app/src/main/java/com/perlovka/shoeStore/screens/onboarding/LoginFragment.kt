package com.perlovka.shoeStore.screens.onboarding

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.perlovka.shoeStore.R
import com.perlovka.shoeStore.databinding.LoginFragmentBinding
import com.perlovka.shoeStore.models.UserPreference
import com.perlovka.shoeStore.models.UserStatus
import kotlinx.coroutines.launch


class LoginFragment : Fragment() {
    private lateinit var userPreference: UserPreference

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val binding: LoginFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.login_fragment, container, false
        )
        // Get a reference to the UsrPreference
        userPreference = UserPreference(requireContext())

        // Observe authStatus if it's AUTHENTICATED navigate to Shoe List Fragment
        userPreference.authStatus.asLiveData().observe(viewLifecycleOwner, Observer{ authenticationState ->
                when (authenticationState) {
                    UserStatus.AUTHENTICATED ->   findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToShoeListFragment())
                }
        })

        // Set action when button is pressed
        binding.loginButton.setOnClickListener {
            loginSigUpButtonClicked(binding.emailEditText.text.toString(), binding.passwordEditText.text.toString())
        }
        binding.signupButton.setOnClickListener {
            loginSigUpButtonClicked(binding.emailEditText.text.toString(), binding.passwordEditText.text.toString())
        }
            return binding.root
        }

    // Hide the SupportActionBar in onResume() with .hide() method
    override fun onResume() {
        super.onResume()
        val supportActionBar: ActionBar? = (requireActivity() as AppCompatActivity).supportActionBar
        supportActionBar?.hide()
    }

    private fun loginSigUpButtonClicked(email: String, password: String){
        Log.i("Login Frsgment", "Check email")
        when(!email.isBlank() && password.isNotBlank()){
            true -> {
                // Navigate to next fragment
                findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
                // Update userStatus
                lifecycleScope.launch{
                    userPreference.saveAuthStatus(UserStatus.AUTHENTICATED)
                }

            }
            false ->  {
                // Show Toast message
                Toast.makeText(
                    requireActivity(), "Please fill out all the fields",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}