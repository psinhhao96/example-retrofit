package hutech.com.myapplication.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hutech.com.myapplication.R
import hutech.com.myapplication.model.ItemMovie
import hutech.com.myapplication.model.SectionMovie

class DetailMovieAdapter(private val context: Context, private val listData: ItemMovie) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val SERIES_MOVIE : String = "2"     //Phim bộ
    private val SINGLE_MOVIE : String = "1"     //Phim lẻ

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // 1: -> Phim 1 tập
        // 2: -> Phim bộ
        Log.d("DetailMovieAdapter", "Viewtype: $viewType")
        if(viewType == 0) { //Vị trí thứ 0
            when (listData.typefilm) {
                SERIES_MOVIE -> {
                    val view = LayoutInflater.from(context)
                        .inflate(R.layout.layout_detail_chapters_movie, parent, false)
                    return DetailChaptersMovieViewHolder(view)
                }
                else -> {
                    val view = LayoutInflater.from(context)
                        .inflate(R.layout.layout_detail_movie, parent, false)
                    return DetailMovieViewHolder(view)
                }
            }
        }
        else{
            val view = LayoutInflater.from(context).inflate(R.layout.layout_chapters_movie, parent, false)
            return ChaptersMovieViewHolder(view, context, listData)
        }

//        return if(listData.typefilm.equals("2")){
//
//        } else {
//
//        }

        //ChapterMovie
//
        //NewMovie
//        val view = LayoutInflater.from(context).inflate(R.layout.layout_items_movie, parent, false)
//        return MovieItemsViewHolder(view, context, listData[viewType])
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(position == 0){
            when(listData.typefilm){
                SERIES_MOVIE -> {
                    Log.d("DetailMovieAdapter", "Phim bộ | Position: $position")
                    val holder = holder as DetailChaptersMovieViewHolder
                    holder.updateItem(context, listData)
                }
                SINGLE_MOVIE -> {
                    Log.d("DetailMovieAdapter", "Phim lẻ | Position: $position")
                    val holder = holder as DetailMovieViewHolder
                    holder.updateItem(context, listData)
                }
            }
        }else{
            val holder = holder as ChaptersMovieViewHolder
        }

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return when(listData.typefilm){
            SERIES_MOVIE -> 2
            else -> 1
        }
    }
}