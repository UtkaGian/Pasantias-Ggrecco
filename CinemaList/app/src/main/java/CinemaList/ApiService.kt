package CinemaList

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("search/movie?query={name}&include_adult=false&language=en-US&page=1&api_key=9b065c50c7dbe055f95d9b08d33558ad")
    suspend fun getMovies(@Path("name") movieName:String):Response<movieDataResponse>
}