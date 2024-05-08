package com.example.finalproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ListItemLayoutBinding
class MotorcycleAdapter(val motorcycleList : List<Motorcycle>) : RecyclerView.Adapter<MotorcycleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MotorcycleViewHolder {
        val binding = ListItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MotorcycleViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return motorcycleList.size
    }

    override fun onBindViewHolder(currentViewHolder: MotorcycleViewHolder, position: Int) {
        val currentMotorcycle = motorcycleList[position]
        currentViewHolder.bindMotorcycle(currentMotorcycle)
    }
}