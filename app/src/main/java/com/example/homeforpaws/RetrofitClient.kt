package com.example.homeforpaws

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



object RetrofitClient {
    private const val BASE_URL="https://hfp.p-e.kr/"

    private val getRetrofit by lazy{
        val loggingInterceptor = HttpLoggingInterceptor(object : HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                Log.d("Retrofit", message) // 로그를 출력하거나 적절한 로깅 메커니즘으로 변경할 수 있습니다.
            }
        }).apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }
    val getRetrofitService:MainListService by lazy{getRetrofit.create(MainListService::class.java)}
}