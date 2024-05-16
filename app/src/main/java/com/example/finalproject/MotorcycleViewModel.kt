package com.example.finalproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MotorcycleViewModel : ViewModel() {
    val message = "Need help finding your make?"
   private val motorcycleMakeArray = listOf("Harley-Davidson", "Kawasaki", "Honda", "BMW", "Yamaha", "KTM", "Ducati", "Aprilia", "Suzuki", "Bimota", "Royal Enfield", "Indian", "Alta", "Energica")

    private val _counter = MutableLiveData(0)
    val counter : LiveData<Int>
        get() = _counter

    private val _compare = MutableLiveData(false)
    val compare : LiveData<Boolean>
        get() = _compare
    fun makeMatch(userInput : String): Boolean {
        for (motorcycleMakes in motorcycleMakeArray) {
            if (userInput == motorcycleMakes) {
                return true
            }
        }
        comparison()
        return false
    }
    fun incrimentCounter() {
        val currentIndex = counter.value ?: 0
        _counter.value = currentIndex + 1
    }

    fun resetCounter(){
        _counter.value = 0
        _compare.value = false
    }

    private fun comparison(){
        if(counter.value == 3){
            _compare.value = true
        }
    }





}