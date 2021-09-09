package com.perlovka.shoeStore.screens.welcome
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.perlovka.shoeStore.R
import com.perlovka.shoeStore.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for fragment
        val binding: WelcomeFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.welcome_fragment, container, false
        )

        binding.welcomeButton.setOnClickListener{
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionFragment())
        }
        return binding.root
    }
}