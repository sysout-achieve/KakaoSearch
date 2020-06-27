package com.gun.kakaosearch.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitKakao {
    const val API_KEY = "7870422525a27a269af6fc796351d18f"
    const val BASE_URL = "dapi.kakao.com"

    fun getService(): BookSearchService = retrofit.create(
        BookSearchService::class.java)

    private val retrofit =
        Retrofit.Builder()
            .baseUrl("https://" + BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}