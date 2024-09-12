package CinemaList

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.cinemalist.R
import com.example.cinemalist.databinding.ActivityDetailMovieBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding= ActivityDetailMovieBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        val id:Int= intent.getIntExtra("id", 0)
        getMovieData(id)
    }
    private fun getMovieData(id:Int){
        CoroutineScope(Dispatchers.IO).launch{
            val movieDetail= getRetrofit().create(ApiService::class.java).getMovieData(id)
            if(movieDetail.body() != null){
                runOnUiThread { createUi(movieDetail.body()!!) }
            }
        }
    }
    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun createUi(movie: MovieDetailResponse){
        Log.i("gg", movie.toString())
        val url="https://image.tmdb.org/t/p/w500"+movie.posterPath
        Picasso.get().load(url).into(binding.ivPoster)
    }
}