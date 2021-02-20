package hutech.com.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hutech.com.myapplication.viewmodel.MovieViewModel

class MovieActivity : AppCompatActivity() {
    private lateinit var recyclerview : RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private val movieViewModel : MovieViewModel = MovieViewModel()
    private lateinit var movieAdapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        recyclerview = findViewById(R.id.recyclerview_activity_movie)
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = layoutManager

        callApi()
        movieViewModel.data.observe(this){
            movieAdapter = MovieAdapter(this, it)
            recyclerview.adapter = movieAdapter
        }

    }

    private fun callApi(){
        movieViewModel.getData()
    }
}