package com.example.finalproject
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Headers


private const val QUERY_STRING = "?make=Kawasaki&model=Ninja"


interface MotorcycleApiInterface {
    @Headers("X-Api-Key: uBejY3WJOIr1rrgMBJ93IA==HjIWcQI0em8p6CGs")
    @GET(QUERY_STRING)
    fun getMotorcycles() : Call<String>
}
private const val BASE_URL = "https://api.api-ninjas.com/v1/motorcycles/"
private val retrofitObject = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(ScalarsConverterFactory.create()).build()

object MotorcycleApiObject{
    val motorcycleApiObject : MotorcycleApiInterface by lazy {
        retrofitObject.create(MotorcycleApiInterface::class.java)
    }
}