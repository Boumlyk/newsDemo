package com.hmzeda.newsdemo.module.cookies

import NewsObject
import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Cookies @Inject constructor(@ApplicationContext context: Context) {


    lateinit var newsClicked:NewsObject



}