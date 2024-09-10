package CinemaList

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemalist.databinding.ItemMovieBinding

class MoviesViewHolder(view:View): RecyclerView.ViewHolder(view){

    private val binding= ItemMovieBinding.bind(view)

    fun bind(movieItemResponse: movieItemResponse){
        binding.movieOgTitle.text= movieItemResponse.ogTitle
    }
}