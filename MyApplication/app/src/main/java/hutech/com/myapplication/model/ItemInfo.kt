package hutech.com.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ItemInfo {
    @SerializedName("value")
    @Expose
    var value : String = ""

    @SerializedName("text")
    @Expose
    var text : String = ""

    override fun toString(): String {
        return "Info(value='$value', text='$text')"
    }

}