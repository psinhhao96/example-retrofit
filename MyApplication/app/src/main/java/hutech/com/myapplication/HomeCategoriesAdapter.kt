package hutech.com.myapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import hutech.com.myapplication.model.Category
import hutech.com.myapplication.model.Item
import hutech.com.myapplication.model.Section
import java.util.zip.Inflater

class HomeCategoriesAdapter(private val context: Context, private val data: Section) : RecyclerView.Adapter<HomeCategoriesAdapter.HomeCategoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeCategoriesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_home_categories, parent, false)
        return HomeCategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeCategoriesViewHolder, position: Int) {
        if(data.items.size > 0){
            holder.updateItems(data.items[position])
            holder.itemViewClick(holder.itemView)
        }

//        holder.itemView.setOnClickListener {
//            val intent: Intent = Intent(context, MovieActivity::class.java)
//            context.startActivity(intent)
//        }

    }

    override fun getItemCount(): Int {
        return data.items.size
    }

    inner class HomeCategoriesViewHolder : RecyclerView.ViewHolder{
        internal var txtTitle : TextView
        internal var txtSubtitle : TextView
        internal var imageView : ImageView
        //private var itemView: View = View(context)
        constructor(itemView : View) : super(itemView){
            txtTitle = itemView.findViewById(R.id.txt_title_item_home_categories)
            txtSubtitle = itemView.findViewById(R.id.txt_subtitle_item_home_categories)
            imageView = itemView.findViewById(R.id.imgview_item_home_categories)

        }

        fun updateItems(item: Item){
            txtTitle.text = item.title
            txtSubtitle.text = item.sub_title
            Glide.with(context).load(item.image).into(imageView)
        }

        fun itemViewClick(itemView: View){
            itemView.setOnClickListener{
                val intent = Intent(context, MovieActivity::class.java)
                context.startActivity(intent)
            }
        }

    }
}