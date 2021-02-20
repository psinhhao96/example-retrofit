package hutech.com.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SectionHomeRespone {
    @SerializedName("data")
    @Expose
    var data : List<Section> = listOf()
}