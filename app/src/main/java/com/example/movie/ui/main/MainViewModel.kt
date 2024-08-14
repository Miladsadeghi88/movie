package com.example.movie.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.movie.api.RetrofitClient
import com.example.movie.model.MovieListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val _movies = MutableLiveData<MovieListModel>()
    val movies: LiveData<MovieListModel> get() = _movies

    private val _error = MutableLiveData<String>()
    val error : LiveData<String> get() = _error

    fun getAllList(){

        RetrofitClient.retrofitService.getMovies().enqueue(object :Callback<MovieListModel>{
            override fun onResponse(
                call: Call<MovieListModel>,
                response: Response<MovieListModel>
            ) {
                if (response.isSuccessful){
                    _movies.postValue(response.body())
                } else {
                   _error.postValue(response.message())
                }
            }

            override fun onFailure(call: Call<MovieListModel>, t: Throwable) {
                _error.postValue(t.message)
            }
        })
    }
}