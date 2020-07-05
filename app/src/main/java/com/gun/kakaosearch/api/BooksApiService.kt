package com.gun.kakaosearch.api

import com.gun.kakaosearch.api.RetrofitKakao.API_KEY
import com.gun.kakaosearch.domain.ResultBook
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface  BookSearchService {
    @Headers("Authorization: KakaoAK $API_KEY")
    @GET("/v3/search/book")
    fun requestSearchBook(
        @Query("query") keyword: String,
        @Query("sort") sort: String = "accuracy",
        @Query("page") page: Int,
        @Query("size") size: Int = 50
    ): Call<ResultBook>


    @Headers("Authorization: KakaoAK $API_KEY")
    @GET("/v3/search/book")
    fun requestSearchObservable(
        @Query("query") keyword: String,
        @Query("sort") sort: String = "accuracy",
        @Query("page") page: Int,
        @Query("size") size: Int = 50
    ): Observable<ResultBook>
}