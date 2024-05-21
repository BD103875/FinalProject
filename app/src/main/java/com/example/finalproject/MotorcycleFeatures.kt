package com.example.finalproject
import com.squareup.moshi.Json

class MotorcycleFeatures {

    @Json(name = "make")
    var make: String = ""

    @Json(name = "model")
    var model: String = ""

    @Json(name = "year")
    var year: Int = 0

    @Json(name = "type")
    var type: String = ""

    @Json(name = "engine")
    var engine: String = ""
}