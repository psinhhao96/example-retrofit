package hutech.com.myapplication.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hutech.com.myapplication.R

import hutech.com.myapplication.model.Section

class HomeBannerAdapter(private val context: Context, private val data: Section ) :
    RecyclerView.Adapter<HomeBannerAdapter.HomeBannerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeBannerViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_home_banner, parent,false)
        return HomeBannerViewHolder(view)

    }

    override fun onBindViewHolder(holder: HomeBannerViewHolder, position: Int) {
        Log.d("HomeBannerAdapter","imageURL: ${data.items[position].image}")
        //Picasso.with(context).load(data.items[position].image).into(holder.imageView)
        Glide.with(context)
            .load(data.items[position].image)
            .into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return data.items.size
    }

    inner class HomeBannerViewHolder : RecyclerView.ViewHolder{
        internal var imageView : ImageView
        constructor(itemView : View) : super(itemView) {
            imageView = itemView.findViewById(R.id.imgview_item_home_banner)
        }

    }
}