package com.example.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.finalproject.databinding.FragmentHelpBinding


class helpFragment : Fragment() {

    private var _binding: FragmentHelpBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHelpBinding.inflate(inflater, container, false)


        binding.questionButton.setOnClickListener{
            val action = helpFragmentDirections.actionHelpFragmentToMakesSupported()
            binding.root.findNavController()
                .navigate(action)
        }

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
