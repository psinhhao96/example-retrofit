package hutech.com.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemCategory {


    @SerializedName("id")
    @Expose
    var id : String = ""

    @SerializedName("title")
    @Expose
    var title : String = ""

    @SerializedName("sub_title")
    @Expose
    var sub_title : String = ""

    @SerializedName("image")
    @Expose
    var image : String = ""

    override fun toString(): String {
        return "ItemCategory(id='$id', title='$title', sub_title='$sub_title', image='$image')"
    }


}