package CinemaList

import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemalist.databinding.ItemMovieBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MoviesViewHolder(view:View): RecyclerView.ViewHolder(view){

    private val binding= ItemMovieBinding.bind(view)

    fun bind(movieItemResponse: movieItemResponse){
        binding.movieOgTitle.text= movieItemResponse.ogTitle
        val url="https://image.tmdb.org/t/p/w500"+movieItemResponse.poster
        Log.i("gg", "$url")
        Picasso.get().load(url).into(binding.ivPoster)
    }
}