package com.hmzeda.newsdemo.data.local.doa

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hmzeda.newsdemo.module.news.NewsObject
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateNews(news: NewsObject?): Single<Long?>

    /*@Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdateNews(news: List<NewsObject>?): Single<Long?>*/

    @Query("SELECT * FROM news WHERE id = :id")
    fun getNewsById(id: String?): Single<NewsObject?>

    @Query("SELECT EXISTS(SELECT * FROM news WHERE id = :id)")
    fun exist(id: String?): Single<Boolean?>

    @Query("SELECT * FROM news")
    fun getNews(): Single<List<NewsObject>>

    @Query("DELETE FROM news")
    fun deleteAll(): Completable
}