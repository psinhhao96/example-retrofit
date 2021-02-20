package hutech.com.myapplication.manager

import android.os.Handler
import androidx.lifecycle.LiveData
import hutech.com.myapplication.model.Section
import hutech.com.myapplication.model.SectionHomeRespone
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://5ff70052e7164b0017e19fd4.mockapi.io/"
const val GET_LIST_HOME : String = "home-list"
const val GET_LIST_MOVIE: String = "movies"
interface ApiService {
    @GET(GET_LIST_HOME)
    fun getHomes(): Call<List<SectionHomeRespone>>
    @GET(GET_LIST_MOVIE)
    fun getMovies(): Call<List<SectionHomeRespone>>

}