package hutech.com.myapplication.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hutech.com.myapplication.R
import hutech.com.myapplication.model.ItemMovie
import hutech.com.myapplication.model.SectionMovie

class DetailItemAdapter(private val context: Context): RecyclerView.Adapter<ItemMovieViewHolder>() {
    private var dataItemMovie: List<ItemMovie> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemMovieViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return ItemMovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemMovieViewHolder, position: Int) {
        if(dataItemMovie.isNotEmpty()){
            holder.updateItem(context, dataItemMovie[position])
            Log.d("DetailItemAdapter", "data: ${dataItemMovie[position]}")
        }
    }

    override fun getItemCount(): Int {
        return dataItemMovie.size
    }

    fun updateData(listItemMovie: List<ItemMovie>){
        dataItemMovie = listItemMovie
        notifyDataSetChanged()
    }
}