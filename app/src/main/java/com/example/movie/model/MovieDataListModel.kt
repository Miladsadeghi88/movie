package com.example.movie.model

data class MovieDataListModel(
    val id : Int? = null,
    val title : String? = null,
    val poster : String? = null,
    val year : String? = null,
    val country : String? = null,
    val imdb_rating : String? = null,
    val genres : List<String>? = null,
    val images : List<String>? = null,
)
