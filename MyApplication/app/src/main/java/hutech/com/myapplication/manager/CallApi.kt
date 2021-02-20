package hutech.com.myapplication.manager

import android.util.Log
import com.google.gson.Gson
import hutech.com.myapplication.model.SectionHomeRespone
import hutech.com.myapplication.model.Section
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CallApi {
    fun getCurrentData(onSuccess : (List<Section>) -> Unit, onFailure: (ErrorCode)->Unit){
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

    fun getPosterData(onSuccess: (List<Section>) -> Unit, onFailure: (ErrorCode) -> Unit){
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(ApiService::class.java)
        val call = service.getMovies()
        call.enqueue(object : Callback<List<SectionHomeRespone>> {
            override fun onResponse(
                call: Call<List<SectionHomeRespone>>?,
                response: Response<List<SectionHomeRespone>>?
            ) {
                if (response?.code() == 200){
                    Log.d("CallApi","getPosterData------Code: ${response?.code()}")
                    val apiRespone = response.body()[0]
                    Log.d("CallApi","getPosterData------Data: ${apiRespone.data}")
                    onSuccess(apiRespone.data)
                }
            }

            override fun onFailure(call: Call<List<SectionHomeRespone>>?, t: Throwable?) {
                onFailure(ErrorCode.CONNECTFAIL)
            }

        })
    }
}