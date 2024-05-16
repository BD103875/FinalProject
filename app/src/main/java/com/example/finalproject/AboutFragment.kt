package com.example.finalproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalproject.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {
    private var _binding: FragmentAboutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)


        binding.websiteImplicitIntentButton.setOnClickListener {
            val webIntent: Intent = Uri.parse("https://api-ninjas.com").let { webpage ->
                Intent(Intent.ACTION_VIEW, webpage)
            }
            startActivity(webIntent)
        }
       binding.questionsButton.setOnClickListener {
           val webIntent: Intent = Uri.parse("https://api-ninjas.com/contact").let { webpage ->
               Intent(Intent.ACTION_VIEW, webpage)
           }
           startActivity(webIntent)
       }

        return binding.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    }
