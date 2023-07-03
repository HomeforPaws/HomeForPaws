package com.example.homeforpaws

import com.google.gson.annotations.SerializedName
import java.io.FileDescriptor


data class DetailResponse(
    @SerializedName("information") val data:Dresponse
)

data class Dresponse(
    val rescue_id:Int,
    val name:String,
    val gender:String,
    val age:Int,
    val image_url:String,
    val species:String,
    val place:String,
    val description:String
)