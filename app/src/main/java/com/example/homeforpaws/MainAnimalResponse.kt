package com.example.homeforpaws

import com.google.gson.annotations.SerializedName

data class MainAnimalResponse(
    @SerializedName("result") val result:List<ListResultResponse>
)

data class ListResultResponse(
    @SerializedName("animal_id") val animalId:Int,
    @SerializedName("name") val name:String,
    @SerializedName("image_url") val imageUrl:String
)