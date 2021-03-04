package hutech.com.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SectionHome: Section {

    constructor(){
        super.title
        super.style
    }
    @SerializedName("items")
    @Expose
    var items : MutableList<ItemCategory> = mutableListOf()

    override fun toString(): String {
        return "SectionHome(titles=$title, style=$style items=$items)"
    }
}