package CinemaList

import com.google.gson.annotations.SerializedName

data class movieDataResponse(
    @SerializedName("page") val page:Int,
    @SerializedName("results") val movies: List<movieItemResponse>
)
data class movieItemResponse(
    @SerializedName("id") val mId:Int,
    @SerializedName("original_title") val ogTitle: String,
    @SerializedName("release_date") val rDate: String,
    @SerializedName("poster_path") val poster: String
)

//https://image.tmdb.org/t/p/w500