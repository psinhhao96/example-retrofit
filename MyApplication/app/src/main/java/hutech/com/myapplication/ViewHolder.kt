package hutech.com.myapplication

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hutech.com.myapplication.model.Item
import hutech.com.myapplication.model.Section
import kotlinx.android.synthetic.main.item_poster_header.view.*

class MoviePosterViewHolder : RecyclerView.ViewHolder, View.OnClickListener {
    private var imgPoster: ImageView
    private var btnSchedule: Button
    private var btnPlay: Button
    private var btnInfo: Button
    private var txtTitle: TextView
    private var txtSubtitle: TextView
    private var controlHeader: View
    private lateinit var item: Item
    var listener: ((Item)->Unit)? = null
    constructor(itemView: View) : super(itemView){
        imgPoster = itemView.findViewById(R.id.img_poster_header)
        controlHeader = itemView.findViewById(R.id.include_poster_header)
        btnSchedule = controlHeader.findViewById(R.id.btn_schedule_item_poster)
        btnPlay = controlHeader.findViewById(R.id.btn_play_item_poster)
        btnInfo = controlHeader.findViewById(R.id.btn_info_item_poster)
        txtTitle = itemView.findViewById(R.id.txt_title_item_poster)
        txtSubtitle = controlHeader.findViewById(R.id.txt_subtitle_item_poster)
//        btnPlay.setOnClickListener {
//            this.itemClick { this.item }
//        }
        btnPlay.setOnClickListener(this)
    }


    fun updateItemView(item: Item){
        this.item = item
        txtTitle.text = item.title
        txtSubtitle.text = item.basic_info
    }

    override fun onClick(p0: View?) {
        this.listener?.invoke(item)
    }
}
class MovieItemsViewHolder : RecyclerView.ViewHolder{
    private var txtTitle: TextView
    private var recyclerView: RecyclerView
    private var linearLayoutManager: LinearLayoutManager

    constructor(itemView: View, context: Context, section: Section) : super(itemView){
        val itemMovieAdapter = ItemMovieAdapter(context, section)
        txtTitle = itemView.findViewById(R.id.txt_title_items_movie)
        recyclerView = itemView.findViewById(R.id.recyclerview_items_movie)
        linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = itemMovieAdapter
    }

    fun updateItem(section: Section){
        txtTitle.text = section.title
    }
}

class ItemMovieViewHolder: RecyclerView.ViewHolder{
    private val imageView : ImageView
    constructor(itemView: View) : super(itemView){
        imageView = itemView.findViewById(R.id.imgview_item_movie)
    }

    fun updateItem(context: Context, item: Item){
        Glide.with(context)
            .load(item.image)
            .override(100,145) //scale image
            .into(imageView)
    }
}

class EmptyViewHolder: RecyclerView.ViewHolder{
    constructor(itemView: View): super(itemView){
    }
}