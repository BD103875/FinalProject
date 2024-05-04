package com.example.finalproject

import android.os.Bundle
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
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.finalproject.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.searchNowButton.setOnClickListener{
            val action = MainFragmentDirections.actionMainFragmentToMotorcycleFragment(popularManufacturersText = "")
            binding.root.findNavController()
                .navigate(action)
        }

        binding.harleyDavidsonButton.setOnClickListener{
            val action = MainFragmentDirections.actionMainFragmentToMotorcycleFragment(popularManufacturersText = "Harley-Davidson")
            binding.root.findNavController()
                .navigate(action)
        }
        binding.kawasakiButton.setOnClickListener{
            val action = MainFragmentDirections.actionMainFragmentToMotorcycleFragment(popularManufacturersText = "Kawasaki")
            binding.root.findNavController()
                .navigate(action)
        }
        binding.suzukiButton.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToMotorcycleFragment(popularManufacturersText = "Suzuki")
            binding.root.findNavController()
                .navigate(action)
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


        setFragmentResultListener("MAKE_CHOSEN"){requestKey: String, bundle: Bundle ->
            val chosenMake = bundle.getString("MAKE")
            if(chosenMake != ""){
                Toast.makeText(context, "Thanks for choosing $chosenMake", Toast.LENGTH_SHORT).show()
            }
        }





        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    }
