import com.google.gson.annotations.SerializedName

data class NewsObject (

	@SerializedName("id") val id : Int,
	@SerializedName("date") val date : String,
	@SerializedName("date_gmt") val date_gmt : String,
	@SerializedName("modified") val modified : String,
	@SerializedName("modified_gmt") val modified_gmt : String,
	@SerializedName("slug") val slug : String,
	@SerializedName("status") val status : String,
	@SerializedName("type") val type : String,
	@SerializedName("link") val link : String,
	@SerializedName("title") val title : Title,
	@SerializedName("content") val content : Content,
	@SerializedName("excerpt") val shortContent : ShortContent,
	@SerializedName("author") val author : Int,
	@SerializedName("featured_media") val featured_media : Int,
	@SerializedName("comment_status") val comment_status : String,
	@SerializedName("ping_status") val ping_status : String,
	@SerializedName("sticky") val sticky : Boolean,
	@SerializedName("template") val template : String,
	@SerializedName("format") val format : String,
	@SerializedName("meta") val meta : List<String>,
	@SerializedName("categories") val categories : List<Int>,
	@SerializedName("tags") val tags : List<String>,
	@SerializedName("yoast_head") val yoast_head : String,
	@SerializedName("yoast_head_json") val newsInfoMoreInfo : NewsInfoMoreInfo,
)