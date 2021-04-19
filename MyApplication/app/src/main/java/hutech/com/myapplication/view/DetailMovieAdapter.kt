package hutech.com.myapplication.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hutech.com.myapplication.R
import hutech.com.myapplication.model.ItemMovie
import hutech.com.myapplication.model.SectionMovie

class DetailMovieAdapter(private val context: Context) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val SERIES_MOVIE : String = "2"     //Phim bộ
    private val SINGLE_MOVIE : String = "1"     //Phim lẻ
    private var data: ItemMovie? = null
    private var listDataMovies: List<ItemMovie> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // 1: -> Phim 1 tập
        // 2: -> Phim bộ
        Log.d("DetailMovieAdapter", "viewType: $viewType")
        if(viewType == 0) { //Vị trí thứ 0
            when (data?.typefilm) {
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
        else if(viewType == 1 && data?.typefilm?.equals("2") == true){
            val view = LayoutInflater.from(context).inflate(R.layout.layout_chapters_movie, parent, false)
            Log.d("DetailMovieAdapter", "index 1 && typefilm 2")
            return ChaptersMovieViewHolder(view, context, data)
        }
        else{
            //NewMovie
        val view = LayoutInflater.from(context).inflate(R.layout.layout_items_movie, parent, false)
        return DetailItemMovieViewHolder(view, context)
        }

//        return if(listData.typefilm.equals("2")){
//
//        } else {
//
//        }

        //ChapterMovie
//

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(position == 0){
            Log.d("DetailMovieAdapter", "typefilm: ${data?.typefilm}")
            when(data?.typefilm){
                SERIES_MOVIE -> {
                    Log.d("DetailMovieAdapter", "Phim bộ | Position: $position")
                    val holder = holder as DetailChaptersMovieViewHolder
                    holder.updateItem(context, data)
                }
                else -> {
                    Log.d("DetailMovieAdapter", "Phim lẻ | Position: $position")
                    val holder = holder as DetailMovieViewHolder
                    holder.updateItem(context, data)
                }
            }
        }else if(position == 1 && data?.typefilm?.equals("2") == true){
            val holder = holder as ChaptersMovieViewHolder
        }else{
            val holder = holder as DetailItemMovieViewHolder
            Log.d("DetailMovieAdapter", "DetailItemMovieViewHolder")
            val title = "Có thể bạn thích?"
            holder.updateData(listDataMovies, title)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        if (data != null) {
            return when(data?.typefilm){
                SERIES_MOVIE -> 3
                else -> 2
            }
        }
        return 0
        }

    fun updateData(data: ItemMovie?){
        this.data = data
        notifyDataSetChanged()
    }

    fun updateDataMovies(listMovies: List<ItemMovie>) {
        this.listDataMovies = listMovies
        notifyDataSetChanged()
    }
}