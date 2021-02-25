package hutech.com.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Section {
    @SerializedName("title")
    @Expose
    var title : String = ""


    @SerializedName("style")
    @Expose
    var style : String = ""

    @SerializedName("items")
    @Expose
    var items : MutableList<Item> = mutableListOf()

    constructor()

    override fun toString(): String {
        return "Section(title_section='$title', style='$style', items=$items)"
    }
}