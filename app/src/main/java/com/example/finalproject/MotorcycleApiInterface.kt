package com.example.finalproject
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Headers
import retrofit2.http.Query

interface MotorcycleApiInterface {
    @Headers("X-Api-Key: uBejY3WJOIr1rrgMBJ93IA==HjIWcQI0em8p6CGs")
    @GET("motorcycles")
    fun getMotorcycles(@Query("make") make:String, @Query("model") model: String, @Query("year") year: String) : Call<List<MotorcycleFeatures>>
}
private const val BASE_URL = "https://api.api-ninjas.com/v1/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofitObject = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(
    moshi)).baseUrl(BASE_URL).build()

object MotorcycleApiObject{
    val motorcycleApiObject : MotorcycleApiInterface by lazy {
        retrofitObject.create(MotorcycleApiInterface::class.java)
    }
}