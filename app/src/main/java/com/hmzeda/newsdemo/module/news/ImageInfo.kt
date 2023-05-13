import com.google.gson.annotations.SerializedName

data class ImageInfo (

	@SerializedName("width") val width : Int,
	@SerializedName("height") val height : Int,
	@SerializedName("url") val url : String,
	@SerializedName("type") val type : String
)