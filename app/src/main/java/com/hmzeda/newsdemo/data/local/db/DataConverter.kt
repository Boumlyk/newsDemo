package com.hmzeda.newsdemo.data.local.db

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hmzeda.newsdemo.module.news.ImageInfo

class DataConverter {

    private val type = object : TypeToken<List<ImageInfo>>() {}.type

    @TypeConverter
    fun fromJson(json: String?): List<ImageInfo>? {
        if (json.isNullOrEmpty()){
            return emptyList()
        }
        return Gson().fromJson(json, type)
    }

    @TypeConverter
    fun toJson(image: List<ImageInfo>?): String {
        if (image.isNullOrEmpty()){
            return ""
        }
        return Gson().toJson(image, type)
    }
/*
    @TypeConverter
    fun fromTitleIntToString(title: Title?):String{
        if (title==null){
            return ""
        }
        return Gson().toJson(title)
    }*/
    /*@TypeConverter
    fun toStringToTile(string: String): Title {
        if (string.isNullOrEmpty())
            return Title("")
        return gson.fromJson(string,Title::class.java)
    }
    @TypeConverter
    fun fromContentIntToString(content: Content): String = Gson().toJson(content)
    @TypeConverter
    fun toStringToContent(string: String): Content?{
        return Gson().fromJson(string,Content::class.java)
    }

    @TypeConverter
    fun fromNewsInfoMoreInfoIntToString(newsInfoMoreInfo: NewsInfoMoreInfo?): String = Gson().toJson(newsInfoMoreInfo)
    @TypeConverter
    fun toStringToNewsInfoMoreInfo(string: String?): NewsInfoMoreInfo?{
        return Gson().fromJson(string,NewsInfoMoreInfo::class.java)
    }*/
}