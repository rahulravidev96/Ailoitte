package com.example.ailottecompany.data.network

import com.example.ailottecompany.data.model.NewsApus
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface NewsInteface {

    @GET("articles")
    suspend fun getNews() : Response<List<NewsApus>>

    companion object{
        operator fun invoke() : NewsInteface {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://spaceflightnewsapi.net/api/v2/")
                .build()
                .create(NewsInteface::class.java)
        }
    }
}