package CinemaList

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cinemalist.R
import com.example.cinemalist.databinding.ActivityMovieListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MovieListActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMovieListBinding
    private lateinit var retrofit: Retrofit
    private lateinit var adapter: MovieListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMovieListBinding.inflate(layoutInflater)
        retrofit= getRetrofit()
        setContentView(binding.root)
        initUI()
    }
    private fun initUI(){
        binding.svCinema.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.i("gg", "$query")
                SearchByName(query.orEmpty())
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
        adapter= MovieListAdapter()
        binding.rvCinema.setHasFixedSize(true)
        binding.rvCinema.layoutManager= LinearLayoutManager(this)
        binding.rvCinema.adapter= adapter
    }
    private fun SearchByName(query: String){
        binding.progressBar.isVisible= true
        CoroutineScope(Dispatchers.IO).launch{
            val myResponse= retrofit.create(ApiService::class.java).getMovies(query)
            if (myResponse.isSuccessful){
                val response= myResponse.body()
                if (response!=null){
                    Log.i("gg", response.toString())
                    withContext(Dispatchers.Main){
                        binding.progressBar.isVisible=false
                        adapter.updateList(response.movies)
                    }
                }
                Log.i("gg", "works :)")

            }else{
                withContext(Dispatchers.Main){
                    Log.i("gg", "not works :(")
                }
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