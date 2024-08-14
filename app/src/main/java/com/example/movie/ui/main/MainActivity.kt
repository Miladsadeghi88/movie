package com.example.movie.ui.main

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie.R
import com.example.movie.databinding.ActivityMainBinding
import com.example.movie.ui.main.adapter.MovieListAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private var adapter: MovieListAdapter? = null
    private var layoutManager: LinearLayoutManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        layoutManager = GridLayoutManager(this, 2)
        binding.recyclerView.layoutManager = layoutManager


        viewModel.getAllList()


        viewModel.movies.observe(this) { response ->
            response.data?.let {
                adapter = MovieListAdapter(it, onClick = {

                })

                binding.recyclerView.adapter = adapter
            }

        }

        viewModel.error.observe(this) {

        }


    }
}