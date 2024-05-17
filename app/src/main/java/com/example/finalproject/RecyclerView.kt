package com.example.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.finalproject.databinding.FragmentRecyclerViewBinding


class RecyclerView : Fragment() {
    private var _binding: FragmentRecyclerViewBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MotorcycleViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)


    val motorcycles = listOf(Motorcycle("B","R",1, "A", "N"),Motorcycle("B","R",1, "A", "N"),Motorcycle("B","R",1, "A", "N"),Motorcycle("B","R",1, "A", "N"),Motorcycle("B","R",1, "A", "N"),Motorcycle("B","R",1, "A", "N"),Motorcycle("B","R",1, "A", "N"),Motorcycle("B","R",1, "A", "N"),Motorcycle("B","R",1, "A", "N"),Motorcycle("B","R",1, "A", "N"),Motorcycle("B","R",1, "A", "N"))
    val mAdapter = MotorcycleAdapter(motorcycles)
        binding.recyclerView.adapter = mAdapter

        viewModel.getMotorcycles()

        return binding.root
    }
    }
