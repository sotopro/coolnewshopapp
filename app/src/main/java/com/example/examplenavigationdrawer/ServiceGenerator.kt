package com.example.examplenavigationdrawer

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceGenerator {
    private val client = OkHttpClient.Builder().build()

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://62d83b609c8b5185c785be8c.mockapi.io")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }
}