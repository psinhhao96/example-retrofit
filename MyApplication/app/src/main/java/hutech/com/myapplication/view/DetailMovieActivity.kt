package hutech.com.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hutech.com.myapplication.R
import hutech.com.myapplication.viewmodel.DetailMovieViewModel

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var recyclerview : RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private val detailMovieViewModel = DetailMovieViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        recyclerview = findViewById(R.id.recyclerview_activity_detail_movie)
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = layoutManager

        callApi()
        detailMovieViewModel.data.observe(this){
            val detailMovieAdapter = DetailMovieAdapter(this, it[0])
            recyclerview.adapter = detailMovieAdapter
        }
    }

    private fun callApi(){
        detailMovieViewModel.getData()
    }
}