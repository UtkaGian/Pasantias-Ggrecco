package CinemaList

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cinemalist.R
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MovieListAdapter(
    var movies:List<movieItemResponse> = emptyList(),
    private val onItemSelected:(Int) -> Unit) :
    RecyclerView.Adapter<MoviesViewHolder>() {

    @SuppressLint("NewApi")
    fun updateList(movies:List<movieItemResponse>){
        this.movies = movies.sortedBy{it.rDate}
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater= LayoutInflater.from(parent.context)
        return MoviesViewHolder(layoutInflater.inflate(R.layout.item_movie, parent, false))
    }

    override fun onBindViewHolder(viewholder: MoviesViewHolder, position: Int) {
        val item= movies[position]
        viewholder.bind(item, onItemSelected)
    }

    override fun getItemCount() = movies.size
}