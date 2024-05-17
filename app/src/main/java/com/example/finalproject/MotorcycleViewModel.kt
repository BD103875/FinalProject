package com.example.finalproject

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MotorcycleViewModel : ViewModel() {
    val message = "Need help finding your make?"
   private val motorcycleMakeArray = listOf("Harley-Davidson", "Kawasaki", "Honda", "BMW", "Yamaha", "KTM", "Ducati", "Aprilia", "Suzuki", "Bimota", "Royal Enfield", "Indian", "Alta", "Energica")

    private val _counter = MutableLiveData(0)
    val counter : LiveData<Int>
        get() = _counter


    fun makeMatch(userInput : String): Boolean {
        for (motorcycleMakes in motorcycleMakeArray) {
            if (userInput == motorcycleMakes) {
                return true
            }
        }
        return false
    }
    fun incrimentCounter() {
        val currentIndex = counter.value ?: 0
        _counter.value = currentIndex + 1
    }

    fun resetCounter(){
        _counter.value = 0
    }

    fun getMotorcycles(){
        val request = MotorcycleApiObject.motorcycleApiObject.getMotorcycles()
        request.enqueue(object : Callback<String>{
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.d("RESPONSE", "Failure: "+t.message)
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.d("RESPONSE", response.body().toString())
            }
        })
    }





}