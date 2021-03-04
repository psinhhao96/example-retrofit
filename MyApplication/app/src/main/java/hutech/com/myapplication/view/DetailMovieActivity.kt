package hutech.com.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hutech.com.myapplication.R

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var recyclerview : RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        recyclerview = findViewById(R.id.recyclerview_activity_detail_movie)
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = layoutManager
    }
}