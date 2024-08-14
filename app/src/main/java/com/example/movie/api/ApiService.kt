package com.example.movie.api

import com.example.movie.model.MovieListModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("v1/movies")
    fun getMovies(): Call<MovieListModel>



}