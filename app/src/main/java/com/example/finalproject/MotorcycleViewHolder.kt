package com.example.finalproject

import com.example.finalproject.databinding.ListItemLayoutBinding
import androidx.recyclerview.widget.RecyclerView
class MotorcycleViewHolder(val binding : ListItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    private lateinit var currentMotorcycle : Motorcycle

    fun bindMotorcycle(motorcycle: Motorcycle){
        currentMotorcycle = motorcycle
        binding.motorcycleMake.text = currentMotorcycle.make
        binding.motorcycleModel.text = currentMotorcycle.model
        binding.year.text = currentMotorcycle.year.toString()
        binding.type.text = currentMotorcycle.type
        binding.engine.text = currentMotorcycle.engine
    }
}