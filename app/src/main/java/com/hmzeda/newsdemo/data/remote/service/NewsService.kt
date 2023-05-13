package com.hmzeda.newsdemo.data.remote.service

import NewsObject
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("wp-json/wp/v2/posts")
    fun getNews(@Query("page") int: Int):Single<List<NewsObject>>
}