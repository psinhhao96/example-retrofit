package hutech.com.myapplication.manager

enum class HomeStyle {
    BANNER,
    CATEGORY,
    POSTER_HEADER,
    POSTER_HORIZONTAL,
    ;

    fun style() : String{
        return when(this){
            BANNER -> "56"
            CATEGORY -> "60"
            POSTER_HEADER -> "9"
            POSTER_HORIZONTAL -> "15"
        }
    }

}