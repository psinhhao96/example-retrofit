package hutech.com.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemMovie {
    @SerializedName("id")
    @Expose
    var id : String = ""

    @SerializedName("title")
    @Expose
    var title : String = ""

    @SerializedName("sub_title")
    @Expose
    var sub_title : String = ""

    @SerializedName("description")
    @Expose
    var description : String = ""

    @SerializedName("basic_info")
    @Expose
    var basic_info : String = ""

    @SerializedName("image")
    @Expose
    var image : String = ""

    @SerializedName("typefilm")
    @Expose
    var typefilm: String =""

    @SerializedName("chapters")
    @Expose
    var chapters: MutableList<ItemChapter> = mutableListOf()

    @SerializedName("info")
    @Expose
    val info: MutableList<ItemInfo> = mutableListOf()
    override fun toString(): String {
        return "Item(id='$id', title='$title', sub_title='$sub_title', image='$image')"
    }


}