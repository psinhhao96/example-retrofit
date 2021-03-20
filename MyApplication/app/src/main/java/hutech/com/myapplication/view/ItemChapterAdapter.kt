package hutech.com.myapplication.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hutech.com.myapplication.R
import hutech.com.myapplication.model.ItemMovie
import hutech.com.myapplication.model.SectionMovie

class ItemChapterAdapter(private val context: Context, private val data : ItemMovie) :
    RecyclerView.Adapter<ItemChapterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemChapterViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_chapter_movie, parent, false)
        return ItemChapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemChapterViewHolder, position: Int) {
        holder.updateItem(position)
    }

    override fun getItemCount(): Int {
        return data.chapters.size
    }

}