package hutech.com.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User {

    @SerializedName("email")
    @Expose
    var email : String = ""

    @SerializedName("fullname")
    @Expose
    var fullname : String = ""

    @SerializedName("count")
    @Expose
    var count : String = ""

    @SerializedName("username")
    @Expose
    var username : String = ""

    @SerializedName("password")
    @Expose
    var password : String = ""

    @SerializedName("phone")
    @Expose
    var phone : String = ""

    @SerializedName("favorites")
    @Expose
    var favorites : MutableList<String> = mutableListOf()

    @SerializedName("albumsfollow")
    @Expose
    var albumsfollow : MutableList<String> = mutableListOf()

    constructor(){}

//    constructor(email : String, fullname: String, count : String, username : String, password: String, phone : String, favorites : MutableList<String>, albumsfollow : MutableList<String>){
//        this.email = email
//        this.fullname = fullname
//        this.count = count
//        this.username = username
//        this.password = password
//        this.phone = phone
//        this.favorites = favorites
//        this.albumsfollow = albumsfollow
//    }

    override fun toString(): String {
        return "User(email='$email', fullname='$fullname', count='$count', username='$username', password='$password', phone='$phone', favorites=$favorites, albumsfollow=$albumsfollow)"
    }


}