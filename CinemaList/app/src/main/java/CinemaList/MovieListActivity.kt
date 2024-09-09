package CinemaList

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.cinemalist.R
import com.example.cinemalist.databinding.ActivityMovieListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MovieListActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMovieListBinding
    private lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMovieListBinding.inflate(layoutInflater)
        retrofit= getRetrofit()

        setContentView(binding.root)
    }
    private fun initUI(){
        binding.svCinema.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                SearchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }
    private fun SearchByName(query: String){
        CoroutineScope(Dispatchers.IO).launch{
            val myResponse= retrofit.create(ApiService::class.java).getMovies(query)
            if (myResponse.isSuccessful){
                Log.i("gg", "works :), $myResponse")
                binding.Out.text= myResponse.toString()
            }else{
                Log.i("gg", "not works :(")
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
}