package com.hmzeda.newsdemo.module.news

import com.google.gson.annotations.SerializedName
import com.hmzeda.newsdemo.module.news.ImageInfo

class NewsInfoMoreInfo constructor(@SerializedName("title") val title : String,
                                   @SerializedName("og_image") val imageInfo : List<ImageInfo>) {
}