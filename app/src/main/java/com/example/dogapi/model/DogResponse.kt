package com.example.dogapi.model

import com.squareup.moshi.Json

data class DogResponse(
    @Json (name= "message") var message: List<String>
)

