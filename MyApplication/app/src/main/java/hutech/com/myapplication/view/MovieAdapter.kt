package hutech.com.myapplication.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hutech.com.myapplication.R
import hutech.com.myapplication.manager.HomeStyle
import hutech.com.myapplication.model.SectionMovie

class MovieAdapter(private val context: Context, private val listData: List<SectionMovie>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (listData[viewType].items.size > 0) {
            return when(listData[viewType].style){
                HomeStyle.POSTER_HEADER.style() -> {
                    Log.d("MovieAdapter", "style poster_header: ${HomeStyle.POSTER_HEADER.style()}")
                    val view = LayoutInflater.from(context).inflate(R.layout.layout_poster_header, parent, false)
                    MoviePosterViewHolder(view)
                }
                else -> {
                    Log.d("MovieAdapter", "style poster: ${HomeStyle.POSTER_HORIZONTAL.style()}")
                    val view = LayoutInflater.from(context).inflate(R.layout.layout_items_movie, parent, false)
                    MovieItemsViewHolder(view, context, listData[viewType])
                }
            }
        }else {
            val view = LayoutInflater.from(context).inflate(R.layout.layout_empty, parent, false)
            return EmptyViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(listData[position].items.size > 0){
            when(listData[position].style){
                HomeStyle.POSTER_HEADER.style() -> {
                    val holder = holder as MoviePosterViewHolder
                    if(listData[position].items.size > 0){
                        holder.updateItemView(listData[position].items[0])
                        holder.listener = {
                            Log.d("MovieAdapter", "title_item: ${it.title}")
                        }
                    }
                }
                else -> {
                    val holder = holder as MovieItemsViewHolder
                    if(listData[position].items.size > 0){
                        holder.updateItem(listData[position])
                    }
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }
    override fun getItemCount(): Int {
        return listData.size
    }
}