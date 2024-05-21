package com.example.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.finalproject.databinding.FragmentRecyclerViewBinding
import androidx.lifecycle.Observer

class RecyclerView : Fragment() {
    private var _binding: FragmentRecyclerViewBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MotorcycleViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)

        viewModel.getMotorcycles()
        viewModel.response.observe(viewLifecycleOwner) { motorcyclesList ->
            val adapter = MotorcycleAdapter(motorcyclesList)
            binding.recyclerView.adapter = adapter
        }

        return binding.root
    }
    }
