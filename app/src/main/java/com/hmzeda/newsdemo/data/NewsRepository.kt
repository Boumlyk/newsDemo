package com.hmzeda.newsdemo.data

import com.hmzeda.newsdemo.data.local.doa.NewsDao
import com.hmzeda.newsdemo.data.remote.service.NewsService
import com.hmzeda.newsdemo.module.news.NewsObject
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor(service: NewsService,newsDao: NewsDao){
    var service:NewsService
    private  var newsDao: NewsDao
    init {
        this.service=service
        this.newsDao=newsDao
    }

    fun getNews(int: Int): Single<List<NewsObject>> {
        return service.getNews(int)
    }


    fun getNewsFromLocal(): Single<List<NewsObject>>{
        return newsDao.getNews()
    }

   /* fun insertNewsInRoom(newsObjects: List<NewsObject>): Single<Long?> {
        return newsDao.insertOrUpdateNews(newsObjects)
    }*/

    fun insertNewsInRoom(newsObjects: NewsObject): Single<Long?> {
        return newsDao.insertOrUpdateNews(newsObjects)
    }


}