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


    private val _response = MutableLiveData<List<Motorcycle>>()
    val response : LiveData<List<Motorcycle>>
        get() = _response

    fun getMotorcycles(){
        val request = MotorcycleApiObject.motorcycleApiObject.getMotorcycles()
        request.enqueue(object : Callback<List<MotorcycleFeatures>>{
            override fun onFailure(call: Call<List<MotorcycleFeatures>>, t: Throwable) {
                Log.d("RESPONSE", "Failure: "+t.message)
            }

            override fun onResponse(call: Call<List<MotorcycleFeatures>>, response: Response<List<MotorcycleFeatures>>) {
                var listOfMotorcyclesFetched = mutableListOf<Motorcycle>()

                val motorcycleResponse : List<MotorcycleFeatures>  = response.body() ?: listOf()

                for(motorcycleFeatures in motorcycleResponse){
                    val make = motorcycleFeatures.make
                    val model = motorcycleFeatures.model
                    val year = motorcycleFeatures.year
                    val type = motorcycleFeatures.type
                    val engine = motorcycleFeatures.engine

                    val newMotorcycle = Motorcycle(make, model, year, type, engine)
                    listOfMotorcyclesFetched.add(newMotorcycle)
                }
                _response.value = listOfMotorcyclesFetched

            }
        })
    }





}