package com.example.movie.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.R
import com.example.movie.databinding.MovieCardBinding
import com.example.movie.model.MovieDataListModel
import com.squareup.picasso.Picasso
import java.io.File.separator

class MovieListAdapter(
    private val items: List<MovieDataListModel>,
    val onClick: (item: MovieDataListModel) -> Unit
) : RecyclerView.Adapter<MovieListAdapter.ViewHolderMovie>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMovie {
        return ViewHolderMovie(
            LayoutInflater.from(parent.context).inflate(
                R.layout.movie_card, parent,false)
        )

    }

    override fun onBindViewHolder(holder: ViewHolderMovie, position: Int) {
        val item = items[position]
        holder.binding.apply {
            txtTitle.text = item.title
            txtCountry.text = item.country
            txtYear.text = item.year
            txtImdbRate.text = item.imdb_rating
            val listString = item.genres?.joinToString(separator = ",")
            txtGenres.text = listString
            root.setOnClickListener {
                onClick.invoke(item)
            }
            Picasso.get()
                .load(item.poster)
                .into(imgPoster)


        }
    }

    override fun getItemCount(): Int = items.size

    //inner class
    inner class ViewHolderMovie(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = MovieCardBinding.bind(itemView)
    }
}