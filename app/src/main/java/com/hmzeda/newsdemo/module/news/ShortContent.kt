import com.google.gson.annotations.SerializedName

data class ShortContent (

	@SerializedName("rendered") val rendered : String,
	@SerializedName("protected") val protected : Boolean
)