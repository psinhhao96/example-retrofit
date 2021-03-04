package hutech.com.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SectionMovie: Section {
    constructor(){
        super.title
        super.style
    }

    @SerializedName("items")
    @Expose
    var items : MutableList<ItemMovie> = mutableListOf()

    override fun toString(): String {
        return "SectionHome(titles=$title, style=$style items=$items)"
    }
}