package com.example.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalproject.databinding.FragmentMakesSupportedBinding


class MakesSupported : Fragment() {
    private var _binding: FragmentMakesSupportedBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMakesSupportedBinding.inflate(inflater, container, false)



        return binding.root
    }

    }
