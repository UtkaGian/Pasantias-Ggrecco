package CinemaList

import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(
    @SerializedName("genres"            ) var genres           : ArrayList<Genres> = arrayListOf(),
    @SerializedName("original_language" ) var originalLanguage : String?           = null,
    @SerializedName("overview"          ) var overview         : String?           = null,
    @SerializedName("poster_path"       ) var posterPath       : String?           = null,
    @SerializedName("release_date"      ) var releaseDate      : String?           = null,
    @SerializedName("runtime"           ) var runtime          : Int?              = null,
    @SerializedName("tagline"           ) var tagline          : String?           = null,
    @SerializedName("title"             ) var title            : String?           = null,
    @SerializedName("vote_average"      ) var voteAverage      : Double?           = null

)


data class Genres (

    @SerializedName("id"   ) var id   : Int?    = null,
    @SerializedName("name" ) var name : String? = null

)
