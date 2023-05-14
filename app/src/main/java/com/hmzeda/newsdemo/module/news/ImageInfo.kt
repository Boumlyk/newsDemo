package com.hmzeda.newsdemo.module.news

import com.google.gson.annotations.SerializedName

class ImageInfo constructor(
    @SerializedName("width") val width : Int,
    @SerializedName("height") val height : Int,
    @SerializedName("url") val url : String,
    @SerializedName("type") val type : String
) {
}