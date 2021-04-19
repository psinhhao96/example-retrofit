package hutech.com.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hutech.com.myapplication.R
import hutech.com.myapplication.model.ItemMovie
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
        val detailMovieAdapter = DetailMovieAdapter(this)
        callApi()
        //observer data detailMovies
        detailMovieViewModel.data.observe(this){
            recyclerview.adapter = detailMovieAdapter
            detailMovieAdapter.updateData(it[0])
            Log.d("DetailMovieAcvt-data","itemcount: ${detailMovieAdapter.itemCount}")
        }
        getMoviesRecommend()
//        //observer data movies recommend
        detailMovieViewModel.dataMoviesRecommend.observe(this){
            recyclerview.adapter = detailMovieAdapter
            detailMovieAdapter.updateDataMovies(it)
            Log.d("DetailMovieAcvt-dataMov","itemcount: ${detailMovieAdapter.itemCount}")
        }

    }

    private fun callApi(){
        detailMovieViewModel.getData()
    }

    private fun getMoviesRecommend(){
        detailMovieViewModel.getMoviesRecommend()
    }
}