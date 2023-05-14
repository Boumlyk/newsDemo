package com.hmzeda.newsdemo.module.news

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "news")
class NewsObject constructor(
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @SerializedName("date") val date: String,
    @SerializedName("date_gmt") val date_gmt: String,
    @Embedded(prefix = "content")
    @SerializedName("content") val description: Description,
    @Embedded(prefix = "more")
    @SerializedName("yoast_head_json") val newsInfoMoreInfo: NewsInfoMoreInfo
) {


}