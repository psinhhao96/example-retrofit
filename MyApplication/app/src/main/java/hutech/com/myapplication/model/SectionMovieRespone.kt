package hutech.com.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SectionMovieRespone {
    @SerializedName("data")
    @Expose
    var data : List<SectionMovie> = listOf()
}