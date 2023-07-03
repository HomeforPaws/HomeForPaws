package com.example.homeforpaws

import retrofit2.Call
import retrofit2.http.GET

interface MainListService {
    @GET("list")
    fun getMainList(): Call<MainAnimalResponse>


}