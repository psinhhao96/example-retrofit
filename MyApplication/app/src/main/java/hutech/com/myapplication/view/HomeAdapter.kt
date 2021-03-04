package hutech.com.myapplication.view

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import hutech.com.myapplication.R
import hutech.com.myapplication.manager.HomeStyle
import hutech.com.myapplication.model.SectionHome

class HomeAdapter(private var context: Context, private var listData: List<SectionHome>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        val style = HomeType.values()
//        if(viewType.equals(HomeType.BANNER)){
//
//        }
//        sections[viewtype].style
        return when(listData[viewType].style){
            HomeStyle.BANNER.style() -> {
                Log.d("HomeAdapter","Viewtype: $viewType, listdata[viewtype].type: ${listData[viewType].style}, " +
                        "HomeType.BANNER.type(): ${HomeStyle.BANNER.style()}")
                val view = LayoutInflater.from(context).inflate(R.layout.layout_home_banner, parent, false)
                HomeViewHolder(view, viewType)
            }
            else -> {
                //Log.d("HomeAdapter","Category type: $viewType")
                val view = LayoutInflater.from(context).inflate(R.layout.layout_home_categories, parent, false)
                HomeCategoryViewHolder(view, viewType)
            }
        }


    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        when(listData[position].style){
            HomeStyle.CATEGORY.style() -> {
                val holder = holder as HomeCategoryViewHolder
                Log.d("HomeAdapter","Title: ${listData[position].title}")
                holder.txtTitle.setText(listData[position].title)
            }
        }
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun getItemViewType(position: Int): Int {
        //Log.d("HomeAdapter","getItemViewType, position: $position")
        return position
    }

    inner class HomeViewHolder : RecyclerView.ViewHolder {

        private var recyclerViewHorizontal : RecyclerView
        private var linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        constructor(itemView: View,position: Int) : super(itemView){
            val homeBannerAdapter = HomeBannerAdapter(context, listData[position])
            recyclerViewHorizontal = itemView.findViewById(R.id.recyclerview_layout_home_banner)
            recyclerViewHorizontal.setHasFixedSize(true);
            recyclerViewHorizontal.isNestedScrollingEnabled = false;
            recyclerViewHorizontal.layoutManager = linearLayoutManager;
            recyclerViewHorizontal.itemAnimator = DefaultItemAnimator();
            recyclerViewHorizontal.adapter = homeBannerAdapter
        }

    }

    inner class HomeCategoryViewHolder : RecyclerView.ViewHolder {

        private var recyclerViewHorizontal : RecyclerView
        internal var txtTitle : TextView
        private var linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)

        constructor(itemView: View, position: Int) : super(itemView){
            val homeCategoriesAdapter = HomeCategoriesAdapter(context,listData[position])
            txtTitle = itemView.findViewById(R.id.txt_layout_home_categories)
            recyclerViewHorizontal = itemView.findViewById(R.id.recyclerview_layout_home_categories)
            recyclerViewHorizontal.setHasFixedSize(true);
            recyclerViewHorizontal.isNestedScrollingEnabled = false;
            recyclerViewHorizontal.layoutManager = linearLayoutManager
            recyclerViewHorizontal.itemAnimator = DefaultItemAnimator()
            recyclerViewHorizontal.adapter = homeCategoriesAdapter
        }
    }

}