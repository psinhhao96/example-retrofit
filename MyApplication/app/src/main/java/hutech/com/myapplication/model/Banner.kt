package hutech.com.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Banner {
    @SerializedName("id")
    @Expose
    var id : String = ""

    @SerializedName("title")
    @Expose
    var title : String = ""

    @SerializedName("image")
    @Expose
    var image : String = ""
}