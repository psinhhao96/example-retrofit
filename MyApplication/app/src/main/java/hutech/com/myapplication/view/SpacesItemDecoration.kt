package hutech.com.myapplication.view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SpacesItemDecoration(private val space: Int, private val spanCount: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.right = space
        outRect.bottom = space

//        val position = parent.getChildAdapterPosition(view) // item position
//        val column: Int = position % spanCount // item column
//
//        outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
//        outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
//        if (position >= spanCount) {
//            outRect.top = spacing; // item top
//        }

        if (parent.getChildLayoutPosition(view) == 0){
            outRect.top = space
        } else {
            outRect.top = 0
        }
    }
}