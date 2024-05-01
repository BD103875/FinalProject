package com.example.finalproject

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.finalproject.databinding.FragmentMotorcycleBinding
import com.google.android.material.snackbar.Snackbar


class MotorcycleFragment : Fragment() {
    private var _binding: FragmentMotorcycleBinding? = null
    private val binding get() = _binding!!

    val motorcycleMakeArray = listOf("Harley-Davidson", "Kawasaki", "Honda", "BMW", "Yamaha", "KTM", "Ducati", "Aprilia", "Suzuki", "Bimota", "Royal Enfield", "Indian", "Alta", "Energica")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMotorcycleBinding.inflate(inflater, container, false)

        binding.searchButton.setOnClickListener{view ->
            if(TextUtils.isEmpty(binding.makeText.text.toString())){
                Snackbar.make(binding.myCoordinatorLayout, R.string.promptUser, Snackbar.LENGTH_SHORT).show()
            }
            fun makeMatch(): Boolean {
                for (motorcycleMakes in motorcycleMakeArray) {
                    if (binding.makeText.text.toString() == motorcycleMakes) {
                         return true
                    }
                }
                return false
            }
            if (!(makeMatch())) {
                Toast.makeText(context, R.string.enterValidMakeToast, Toast.LENGTH_SHORT).show()
            }

    }

        return binding.root
    }


    }
