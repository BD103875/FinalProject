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
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.core.os.bundleOf
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.finalproject.databinding.FragmentMotorcycleBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar


class MotorcycleFragment : Fragment() {
    private var _binding: FragmentMotorcycleBinding? = null
    private val binding get() = _binding!!

   // val motorcycleMakeArray = listOf("Harley-Davidson", "Kawasaki", "Honda", "BMW", "Yamaha", "KTM", "Ducati", "Aprilia", "Suzuki", "Bimota", "Royal Enfield", "Indian", "Alta", "Energica")
    private val viewModel: MotorcycleViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMotorcycleBinding.inflate(inflater, container, false)

        val args = MotorcycleFragmentArgs.fromBundle(requireArguments())
        binding.makeText.text = Editable.Factory.getInstance().newEditable(args.popularManufacturersText)





        binding.searchButton.setOnClickListener{view ->


            if(TextUtils.isEmpty(binding.makeText.text.toString())){
                Snackbar.make(binding.myCoordinatorLayout, R.string.promptUser, Snackbar.LENGTH_SHORT).show()
            }
            else if (!(viewModel.makeMatch(binding.makeText.text.toString()))) {
                Toast.makeText(context, R.string.enterValidMakeToast, Toast.LENGTH_SHORT).show()
                viewModel.incrimentCounter()

                if(viewModel.counter.value == 3) {
                    viewModel.resetCounter()
                    val dialog = AppDialogFragment()
                    dialog.show(parentFragmentManager, "AppDialogFragmentTag")
                }
                   }
            else{
                val action = MotorcycleFragmentDirections.actionMotorcycleFragmentToRecyclerView(binding.makeText.text.toString(), binding.modelText.text.toString(), binding.yearText.text.toString())
                binding.root.findNavController().navigate(action)
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


        binding.returnButton.setOnClickListener {
            val motorcycleMakeChosen = args.popularManufacturersText
            setFragmentResult("MAKE_CHOSEN", bundleOf("MAKE" to motorcycleMakeChosen))
            binding.root.findNavController().navigateUp()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    }
