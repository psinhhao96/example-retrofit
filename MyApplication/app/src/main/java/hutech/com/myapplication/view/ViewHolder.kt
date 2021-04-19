package hutech.com.myapplication.view

import android.content.Context
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
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
    private var itemMovieAdapter: ItemMovieAdapter

    constructor(itemView: View, context: Context) : super(itemView){
        itemMovieAdapter = ItemMovieAdapter(context)
        txtTitle = itemView.findViewById(R.id.txt_title_items_movie)
        recyclerView = itemView.findViewById(R.id.recyclerview_items_movie)
        linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = itemMovieAdapter
    }

    fun updateData(section: SectionMovie){
        itemMovieAdapter.updateData(section)
    }

    fun updateItem(section: SectionMovie){
        txtTitle.text = section.title
    }
}

class ItemMovieViewHolder: RecyclerView.ViewHolder{
    private val imageView : ImageView
    private lateinit var context: Context
    constructor(itemView: View) : super(itemView){
        imageView = itemView.findViewById(R.id.imgview_item_movie)
    }

    fun updateItem(context: Context, itemMovie: ItemMovie){
        this.context = context
        Glide.with(context)
            .load(itemMovie.image)
            .apply(RequestOptions.placeholderOf(R.drawable.icon_placeholder))
            .override(100,145) //scale image
            .into(imageView)
    }



    fun itemClick(itemView: View){
        itemView.setOnClickListener {
            val intent = Intent(context, DetailMovieActivity::class.java)
            context.startActivity(intent)
        }

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

    fun updateItem(context: Context, itemMovie: ItemMovie?){
        txtTitle.text = itemMovie?.title
        txtDescription.text = itemMovie?.description
        //Gán thông tin
        if (itemMovie?.info?.size!! > 0){
            txtDirector.text = itemMovie.info[0].value
            txtActor.text = itemMovie.info[1].value
            txtSound.text = itemMovie.info[2].value
            txtCaption.text = itemMovie.info[3].value
        }
        Glide.with(context).load(itemMovie.image).into(imageView)
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

    fun updateItem(context: Context, itemMovie: ItemMovie?){
        txtTitle.text = itemMovie?.title
        txtDescription.text = itemMovie?.description
        //Gán thông tin
        if (itemMovie?.info?.size!! > 0){
            txtDirector.text = itemMovie.info[0].value
            txtActor.text = itemMovie.info[1].value
            txtSound.text = itemMovie.info[2].value
            txtCaption.text = itemMovie.info[3].value
        }
        Glide.with(context).load(itemMovie.image).into(imageView)
    }
}

class ChaptersMovieViewHolder : RecyclerView.ViewHolder{
    private val btnExtend : ImageButton
    private val recyclerView : RecyclerView
    private val btnFull : Button
    private var gridLayoutManager: GridLayoutManager
    constructor(itemView: View, context: Context, data: ItemMovie?): super(itemView){
        val itemChapterAdapter = ItemChapterAdapter(context, data?.chapters.orEmpty())
        gridLayoutManager = GridLayoutManager(context, 5)
        btnExtend = itemView.findViewById(R.id.btn_extend_layout_chapters)
        recyclerView = itemView.findViewById(R.id.recyclerview_layout_chapters)
        btnFull = itemView.findViewById(R.id.btn_full_layout_chapters)
        //val spacingInPixels = R.dimen._15sdp
//        recyclerView.addItemDecoration(SpacesItemDecoration(5, 5))
        recyclerView.setHasFixedSize(true)
//        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.layoutManager = gridLayoutManager

        recyclerView.adapter = itemChapterAdapter
    }

}
class ItemChapterViewHolder : RecyclerView.ViewHolder{
    private val txtNumber : TextView
    constructor(itemView: View): super(itemView){
        txtNumber = itemView.findViewById(R.id.txt_number_item_chapter)
    }

    fun updateItem(position : Int){
        txtNumber.text = (position + 1).toString()
    }
}

class DetailItemMovieViewHolder : RecyclerView.ViewHolder{
    private var txtTitle: TextView
    private var recyclerView: RecyclerView
    private var linearLayoutManager: LinearLayoutManager
    private var detailItemAdapter: DetailItemAdapter

    constructor(itemView: View, context: Context) : super(itemView){
        detailItemAdapter = DetailItemAdapter(context)
        txtTitle = itemView.findViewById(R.id.txt_title_items_movie)
        recyclerView = itemView.findViewById(R.id.recyclerview_items_movie)
        linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = detailItemAdapter
    }

    fun updateData(itemMovie: List<ItemMovie>, title: String){
        detailItemAdapter.updateData(itemMovie)
        txtTitle.text = title
    }


}
