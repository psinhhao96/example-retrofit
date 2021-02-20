package hutech.com.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hutech.com.myapplication.model.Category
import hutech.com.myapplication.viewmodel.HomeViewModel

class HomeActivity : AppCompatActivity() {
    private lateinit var recyclerview : RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var homeAdapter: HomeAdapter
    private var homeViewModel =  HomeViewModel()
    //private lateinit var dataList: MutableList<Category>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        recyclerview = findViewById(R.id.recyclerview_activity_home)
        //dataList = mutableListOf()
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerview.setHasFixedSize(true)
        recyclerview.layoutManager = layoutManager
        val toolbar : androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar_activity_home)
        setSupportActionBar(toolbar)
        val actionBar = supportActionBar

        callApi()
        homeViewModel.data.observe(this){
            homeAdapter = HomeAdapter( this, it)
            recyclerview.adapter = homeAdapter
        }
    }

    private fun callApi(){
        homeViewModel.getData()
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_home, menu)
//        return super.onCreateOptionsMenu(menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            R.id.managerment_toolbar_home -> {
//                Toast.makeText(this, "Điều hướng trang", Toast.LENGTH_SHORT).show()
//            }
//            R.id.alert_toolbar_home -> {
//                Toast.makeText(this, "Thông báo", Toast.LENGTH_SHORT).show()
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }
}