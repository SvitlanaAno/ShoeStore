package com.perlovka.shoeStore.screens.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.perlovka.shoeStore.R
import com.perlovka.shoeStore.databinding.InstructionFragmentBinding
import com.perlovka.shoeStore.screens.welcome.WelcomeFragmentDirections

class InstructionFragment  : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for fragment
        val binding: InstructionFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.instruction_fragment, container, false
        )

        binding.instructionButton.setOnClickListener{
            findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToShoeList())
        }

        return binding.root
    }

}