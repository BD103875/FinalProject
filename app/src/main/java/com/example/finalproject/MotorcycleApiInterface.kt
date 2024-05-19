package com.example.finalproject
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.Headers


private const val QUERY_STRING = "?make=Kawasaki&model=Ninja"


interface MotorcycleApiInterface {
    @Headers("X-Api-Key: uBejY3WJOIr1rrgMBJ93IA==HjIWcQI0em8p6CGs")
    @GET(QUERY_STRING)
    fun getMotorcycles() : Call<String>
}
private const val BASE_URL = "https://api.api-ninjas.com/v1/motorcycles/"
private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofitObject = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(
    moshi)).baseUrl(BASE_URL).build()

object MotorcycleApiObject{
    val motorcycleApiObject : MotorcycleApiInterface by lazy {
        retrofitObject.create(MotorcycleApiInterface::class.java)
    }
}