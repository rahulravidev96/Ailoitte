package com.example.ailottecompany

import com.example.ailottecompany.data.network.NewsInteface


class NewsRepository(
    private val api: NewsInteface
) : SafeApiRequest() {

    suspend fun getMovies() = apiRequest { api.getNews() }

}