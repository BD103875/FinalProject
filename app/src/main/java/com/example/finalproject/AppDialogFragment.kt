package com.example.finalproject

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.finalproject.databinding.FragmentAppDialogBinding
import com.example.finalproject.databinding.FragmentMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder


//class AppDialogFragment : DialogFragment() {
//    private var _binding: FragmentAppDialogBinding? = null
//    private val binding get() = _binding!!
//    private val viewModel: MotorcycleViewModel by viewModels()
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
////    ): Dialog {
//////        val alertDialogBuilder =
//////            MaterialAlertDialogBuilder(requireContext(), R.style.AlertDialogTheme)
//////        alertDialogBuilder.setTitle("Having trouble?")
//////        alertDialogBuilder.setMessage(viewModel.message)
//////        alertDialogBuilder.setPositiveButton("Yes") { dialog, which ->
//////            val action = MotorcycleFragmentDirections.actionMotorcycleFragmentToHelpFragment()
//////            binding.root.findNavController()
//////                .navigate(action)
//////            dialog.dismiss()
//////        }
//////        alertDialogBuilder.setNegativeButton("No") { dialog, which ->
//////            dialog.dismiss()
//////        }
//////       return alertDialogBuilder.create()
////
////    }
//    }
