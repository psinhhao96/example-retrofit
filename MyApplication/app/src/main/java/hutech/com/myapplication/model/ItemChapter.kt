package hutech.com.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemChapter {
    @SerializedName("id")
    @Expose
    var id : String = ""

    @SerializedName("name")
    @Expose
    var name : String = ""

    override fun toString(): String {
        return "ItemChapter(id='$id', name='$name')"
    }
}