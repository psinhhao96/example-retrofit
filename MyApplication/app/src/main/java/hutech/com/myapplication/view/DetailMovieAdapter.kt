package hutech.com.myapplication.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hutech.com.myapplication.R
import hutech.com.myapplication.model.Section

class DetailMovieAdapter(private val context: Context, private val listData : List<Section>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //if(listData[viewType].)
        val view = LayoutInflater.from(context).inflate(R.layout.layout_detail_chapters_movie, parent, false)
        return DetailChaptersMovieViewHolder(view)
        //DetailMovie
//        val view = LayoutInflater.from(context).inflate(R.layout.layout_detail_movie, parent, false)
//        return DetailMovieViewHolder(view)
        //ChapterMovie
//        val view = LayoutInflater.from(context).inflate(R.layout.layout_chapters_movie, parent, false)
//        return ChaptersMovieViewHolder(view)
        //NewMovie
//        val view = LayoutInflater.from(context).inflate(R.layout.layout_items_movie, parent, false)
//        return MovieItemsViewHolder(view, context, listData[viewType])
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return listData.size
    }
}