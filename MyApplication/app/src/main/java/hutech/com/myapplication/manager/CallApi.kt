package hutech.com.myapplication.manager

import android.util.Log
import com.google.gson.Gson
import hutech.com.myapplication.model.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CallApi {
    fun getHomeData(onSuccess : (List<SectionHome>) -> Unit, onFailure: (ErrorCode)->Unit){  //get data home category
        //var onSuccess : (MutableList<Section>) -> Unit
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(ApiService::class.java)
        val call = service.getHomes()
        call.enqueue(object : Callback<List<SectionHomeRespone>>{
            override fun onResponse(
                call: Call<List<SectionHomeRespone>>?,
                response: Response<List<SectionHomeRespone>>?
            ) {
                if(response?.code() == 200){
                    Log.d("CallApi", "getCurrentData------Code: ${response?.code()}")
                    val apiRespone = response.body().get(0)
                    Log.d("CallApi","getCurrentData------Data: ${apiRespone.data}")

                    onSuccess(apiRespone.data)
                }
            }

            override fun onFailure(call: Call<List<SectionHomeRespone>>?, t: Throwable?) {
                onFailure(ErrorCode.CONNECTFAIL)
            }

        })
    }

    fun getPosterData(onSuccess: (List<SectionMovie>) -> Unit, onFailure: (ErrorCode) -> Unit){  //get data movie
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(ApiService::class.java)
        val call = service.getMovies()
        call.enqueue(object : Callback<List<SectionMovieRespone>> {
            override fun onResponse(
                call: Call<List<SectionMovieRespone>>?,
                response: Response<List<SectionMovieRespone>>?
            ) {
                if (response?.code() == 200){
                    Log.d("CallApi","getPosterData------Code: ${response?.code()}")
                    val apiRespone = response.body()[0]
                    Log.d("CallApi","getPosterData------Data: ${apiRespone.data}")
                    onSuccess(apiRespone.data)
                }
            }

            override fun onFailure(call: Call<List<SectionMovieRespone>>?, t: Throwable?) {
                onFailure(ErrorCode.CONNECTFAIL)
            }

        })
    }

    fun getDetailMovie(onSuccess: (List<ItemMovie>) -> Unit, onFailure: (ErrorCode) -> Unit){
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(ApiService::class.java)
        val call = service.getDetailMovie()
        call.enqueue(object : Callback<List<SectionDetailMovieRespone>>{
            override fun onResponse(
                call: Call<List<SectionDetailMovieRespone>>?,
                response: Response<List<SectionDetailMovieRespone>>?
            ) {
                if (response?.code() == 200){
                    val apiRespone = response.body()[0]
                    Log.d("CallApi","getDetailMovie------Data: ${apiRespone.data[0]}")
                    onSuccess(apiRespone.data)
                }
            }

            override fun onFailure(call: Call<List<SectionDetailMovieRespone>>?, t: Throwable?) {
                onFailure(ErrorCode.CONNECTFAIL)
            }
        })
    }
    //Use mockapi account media@tvlagu.com
    fun getMoviesRecommend(onSuccess: (List<ItemMovie>) -> Unit, onFailure: (ErrorCode) -> Unit){
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL_OTHER).addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(ApiService::class.java)
        val call = service.getMoviesRecommend()
        call.enqueue(object : Callback<List<SectionMovieRespone>>{
            override fun onResponse(
                call: Call<List<SectionMovieRespone>>?,
                response: Response<List<SectionMovieRespone>>?
            ) {
                if(response?.code() == 200){
                    val apiRespone = response.body()[0]
                    Log.d("CallApi","getMoviesRecommend------Data: ${apiRespone.items[0]}")
                    onSuccess(apiRespone.items)
                }
            }

            override fun onFailure(call: Call<List<SectionMovieRespone>>?, t: Throwable?) {
                onFailure(ErrorCode.CONNECTFAIL)
            }
        })
    }
}