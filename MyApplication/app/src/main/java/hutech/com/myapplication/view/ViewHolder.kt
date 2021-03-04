package hutech.com.myapplication.view

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import hutech.com.myapplication.R
import hutech.com.myapplication.model.ItemMovie
import hutech.com.myapplication.model.Section
import hutech.com.myapplication.model.SectionMovie

class MoviePosterViewHolder : RecyclerView.ViewHolder, View.OnClickListener {
    private var imgPoster: ImageView
    private var btnSchedule: Button
    private var btnPlay: Button
    private var btnInfo: Button
    private var txtTitle: TextView
    private var txtSubtitle: TextView
    private var controlHeader: View
    private lateinit var itemMovie: ItemMovie
    var listener: ((ItemMovie)->Unit)? = null
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


    fun updateItemView(itemMovie: ItemMovie){
        this.itemMovie = itemMovie
        txtTitle.text = itemMovie.title
        txtSubtitle.text = itemMovie.basic_info
    }

    override fun onClick(p0: View?) {
        this.listener?.invoke(itemMovie)
    }
}
class MovieItemsViewHolder : RecyclerView.ViewHolder{
    private var txtTitle: TextView
    private var recyclerView: RecyclerView
    private var linearLayoutManager: LinearLayoutManager

    constructor(itemView: View, context: Context, section: SectionMovie) : super(itemView){
        val itemMovieAdapter = ItemMovieAdapter(context, section)
        txtTitle = itemView.findViewById(R.id.txt_title_items_movie)
        recyclerView = itemView.findViewById(R.id.recyclerview_items_movie)
        linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = itemMovieAdapter
    }

    fun updateItem(section: SectionMovie){
        txtTitle.text = section.title
    }
}

class ItemMovieViewHolder: RecyclerView.ViewHolder{
    private val imageView : ImageView
    constructor(itemView: View) : super(itemView){
        imageView = itemView.findViewById(R.id.imgview_item_movie)
    }

    fun updateItem(context: Context, itemMovie: ItemMovie){
        Glide.with(context)
            .load(itemMovie.image)
            .apply(RequestOptions.placeholderOf(R.drawable.icon_placeholder))
            .override(100,145) //scale image
            .into(imageView)
    }
}

class EmptyViewHolder: RecyclerView.ViewHolder {
    constructor(itemView: View) : super(itemView) {
    }
}
class DetailChaptersMovieViewHolder : RecyclerView.ViewHolder{
    private val imageView : ImageView
    private val txtTitle : TextView
    private val txtInfo : TextView
    private val txtDescription : TextView
    private val txtDirector : TextView
    private val txtActor : TextView
    private val txtSound : TextView
    private val txtCaption : TextView
    constructor(itemView: View): super(itemView){
        imageView = itemView.findViewById(R.id.img_layout_detail_chapters_movie)
        txtTitle = itemView.findViewById(R.id.txt_title_detail_chapters_movie)
        txtDescription = itemView.findViewById(R.id.txt_description_detail_chapters_movie)
        txtDirector = itemView.findViewById(R.id.txt_director_detail_chapters_movie)
        txtActor = itemView.findViewById(R.id.txt_actor_detail_chapters_movie)
        txtSound = itemView.findViewById(R.id.txt_sound_detail_chapters_movie)
        txtCaption = itemView.findViewById(R.id.txt_caption_detail_chapters_movie)
        txtInfo = itemView.findViewById(R.id.txt_info_detail_chapters_movie)
    }
}

class DetailMovieViewHolder : RecyclerView.ViewHolder{
    private val imageView : ImageView
    private val btnPlay : Button
    private val txtTitle : TextView
    private val txtInfo : TextView
    private val txtDescription : TextView
    private val txtDirector : TextView
    private val txtActor : TextView
    private val txtSound : TextView
    private val txtCaption : TextView
    constructor(itemView: View): super(itemView){
        imageView = itemView.findViewById(R.id.img_layout_detail_movie)
        btnPlay = itemView.findViewById(R.id.btn_play_detail_movie)
        txtTitle = itemView.findViewById(R.id.txt_title_detail_movie)
        txtDescription = itemView.findViewById(R.id.txt_description_detail_movie)
        txtDirector = itemView.findViewById(R.id.txt_director_detail_movie)
        txtActor = itemView.findViewById(R.id.txt_actor_detail_movie)
        txtSound = itemView.findViewById(R.id.txt_sound_detail_movie)
        txtCaption = itemView.findViewById(R.id.txt_caption_detail_movie)
        txtInfo = itemView.findViewById(R.id.txt_info_detail_movie)
    }
}

class ChaptersMovieViewHolder : RecyclerView.ViewHolder{
    private val btnExtend : ImageButton
    private val recyclerView : RecyclerView
    private val btnFull : Button
    constructor(itemView: View): super(itemView){
        btnExtend = itemView.findViewById(R.id.btn_extend_layout_chapters)
        recyclerView = itemView.findViewById(R.id.recyclerview_layout_chapters)
        btnFull = itemView.findViewById(R.id.btn_full_layout_chapters)
    }
}
class ItemChapterViewHolder : RecyclerView.ViewHolder{
    private val txtNumber : TextView
    constructor(itemView: View): super(itemView){
        txtNumber = itemView.findViewById(R.id.txt_number_item_chapter)
    }

    fun updateItem(position : Int){
        txtNumber.setText(position + 1)
    }
}
