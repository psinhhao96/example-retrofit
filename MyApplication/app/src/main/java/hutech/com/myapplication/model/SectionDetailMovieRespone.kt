package hutech.com.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SectionDetailMovieRespone {
    @SerializedName("data")
    @Expose
    var data : List<ItemMovie> = listOf()
}