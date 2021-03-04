package hutech.com.myapplication.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hutech.com.myapplication.R
import hutech.com.myapplication.model.SectionMovie

class ItemMovieAdapter(private val context: Context, private val data: SectionMovie) :
    RecyclerView.Adapter<ItemMovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemMovieViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return ItemMovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemMovieViewHolder, position: Int) {
        Log.d("ItemMovieAdapter", "Position: $position")
        holder.updateItem(context, data.items[position])
    }

    override fun getItemCount(): Int {
        Log.d("ItemMovieAdapter", "getItemCount - size: ${data.items.size}")
        return data.items.size
    }


}