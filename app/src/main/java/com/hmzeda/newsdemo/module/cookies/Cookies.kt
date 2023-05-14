package com.hmzeda.newsdemo.module.cookies

import android.content.Context
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hmzeda.newsdemo.module.news.NewsObject
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Cookies @Inject constructor(@ApplicationContext context: Context) {

    @PrimaryKey
    var id:Int = 0

    lateinit var newsClicked: NewsObject



}