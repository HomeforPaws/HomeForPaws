package com.example.homeforpaws

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MainListService {
    @GET("animal/list")
    fun getMainList(): Call<MainAnimalResponse>

    @GET("animal/{id}")
    fun getAnimal(@Path("id") id:Int):Call<DetailResponse>

}