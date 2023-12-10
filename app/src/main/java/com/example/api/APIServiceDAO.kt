package com.example.api

import com.example.api.Datas.Product
import com.example.api.Datas.ResponseProduct
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface APIServiceDAO {

    @GET(productInfo)
    suspend fun getAllProduct (): Response<ResponseProduct>

    // one product
    @GET(PRODUCT)
    suspend fun getProductById (@Path ("id") id : Int ): Response<Product>

}