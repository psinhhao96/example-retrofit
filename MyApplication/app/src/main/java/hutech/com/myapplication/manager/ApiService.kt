package hutech.com.myapplication.manager

import hutech.com.myapplication.model.SectionHomeRespone
import hutech.com.myapplication.model.SectionMovieRespone
import retrofit2.Call
import retrofit2.http.GET

const val BASE_URL = "https://5ff70052e7164b0017e19fd4.mockapi.io/"
const val GET_LIST_HOME : String = "home-list"
const val GET_LIST_MOVIE: String = "movies"
const val GET_DETAIL_MOVIE: String = "detail-movie"
interface ApiService {
    @GET(GET_LIST_HOME)
    fun getHomes(): Call<List<SectionHomeRespone>>
    @GET(GET_LIST_MOVIE)
    fun getMovies(): Call<List<SectionMovieRespone>>
    @GET(GET_DETAIL_MOVIE)
    fun getDetailMovie(): Call<List<SectionMovieRespone>>
}