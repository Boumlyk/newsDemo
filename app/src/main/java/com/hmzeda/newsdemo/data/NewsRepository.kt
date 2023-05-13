package com.hmzeda.newsdemo.data

import NewsObject
import com.hmzeda.newsdemo.data.remote.service.NewsService
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(service: NewsService){
    lateinit var service:NewsService
    init {
        this.service=service
    }

    fun getNews(int: Int): Single<List<NewsObject>> {
        return service.getNews(int)
    }

}