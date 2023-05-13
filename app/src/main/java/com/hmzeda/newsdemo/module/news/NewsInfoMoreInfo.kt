import com.google.gson.annotations.SerializedName

data class NewsInfoMoreInfo (

	@SerializedName("title") val title : String,
	@SerializedName("canonical") val canonical : String,
	@SerializedName("og_locale") val og_locale : String,
	@SerializedName("og_type") val og_type : String,
	@SerializedName("og_title") val og_title : String,
	@SerializedName("og_description") val og_description : String,
	@SerializedName("og_url") val og_url : String,
	@SerializedName("og_site_name") val og_site_name : String,
	@SerializedName("article_publisher") val article_publisher : String,
	@SerializedName("article_published_time") val article_published_time : String,
	@SerializedName("og_image") val imageInfo : List<ImageInfo>,
	@SerializedName("author") val author : String,
	@SerializedName("twitter_card") val twitter_card : String,
)