package CinemaList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemalist.R

class MovieListAdapter(var movies:List<movieItemResponse> = emptyList()) : RecyclerView.Adapter<MoviesViewHolder>() {

    fun updateList(movies:List<movieItemResponse>){
        this.movies=movies
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return MoviesViewHolder(layoutInflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(viewholder: MoviesViewHolder, position: Int) {
        val item= movies[position]
        viewholder.bind(item)
    }

    override fun getItemCount() = movies.size
}