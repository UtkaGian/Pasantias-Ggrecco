package CinemaList

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("search/movie")
    //suspend fun getMovies(@Path("name") movieName:String):Response<movieDataResponse>
    suspend fun getMovies(
        @Query("query") movieName: String,
        @Query("include_adult") includeAdult: Boolean = false,
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
        @Query("api_key") apiKey: String= "9b065c50c7dbe055f95d9b08d33558ad"
    ): Response<movieDataResponse>

    @GET("movie/{id}?&api_key=9b065c50c7dbe055f95d9b08d33558ad")
    suspend fun getMovieData(
        @Path("id") movieId:Int
    ):Response<MovieDetailResponse>
}
