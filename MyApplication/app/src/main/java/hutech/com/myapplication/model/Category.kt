package hutech.com.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Category {


    @SerializedName("id")
    @Expose
    var id : String = ""

    @SerializedName("name")
    @Expose
    var name : String = ""

    @SerializedName("image")
    @Expose
    var image : String = ""

    override fun toString(): String {
        return "Category(id='$id', name='$name', image='$image')"
    }

}