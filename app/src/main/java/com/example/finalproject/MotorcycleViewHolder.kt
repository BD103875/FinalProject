package com.example.finalproject

import com.example.finalproject.databinding.ListItemLayoutBinding
import androidx.recyclerview.widget.RecyclerView
class MotorcycleViewHolder(val binding : ListItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentMotorcycle : Motorcycle

    fun bindMotorcycle(motorcycle: Motorcycle){
        currentMotorcycle = motorcycle
        
    }
}