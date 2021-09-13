package com.perlovka.shoeStore.screens.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.perlovka.shoeStore.R
import com.perlovka.shoeStore.databinding.InstructionFragmentBinding

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