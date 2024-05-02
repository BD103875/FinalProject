package com.example.finalproject

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
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

        val args = MotorcycleFragmentArgs.fromBundle(requireArguments())
        binding.makeText.text = Editable.Factory.getInstance().newEditable(args.popularManufacturersText)


        binding.searchButton.setOnClickListener{view ->

            fun makeMatch(): Boolean {
                for (motorcycleMakes in motorcycleMakeArray) {
                    if (binding.makeText.text.toString() == motorcycleMakes) {
                         return true
                    }
                }
                return false
            }
            if(TextUtils.isEmpty(binding.makeText.text.toString())){
                Snackbar.make(binding.myCoordinatorLayout, R.string.promptUser, Snackbar.LENGTH_SHORT).show()
            }
            else if (!(makeMatch())) {
                Toast.makeText(context, R.string.enterValidMakeToast, Toast.LENGTH_SHORT).show()
            }

    }
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menuInflater.inflate(R.menu.options_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection
                return NavigationUI.onNavDestinationSelected(menuItem, requireView().findNavController())
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    }
