package com.example.examplenavigationdrawer

import retrofit2.http.GET
import retrofit2.Call

interface ApiService {
    @GET("/products")
    fun getProducts(): Call<List<ProductModel>>
}