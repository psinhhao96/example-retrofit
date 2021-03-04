package hutech.com.myapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import hutech.com.myapplication.manager.CallApi
import hutech.com.myapplication.manager.ErrorCode
import hutech.com.myapplication.model.SectionHomeRespone
import hutech.com.myapplication.model.Section
import hutech.com.myapplication.model.SectionHome

class HomeViewModel {
    private val callApi : CallApi = CallApi()
    var data = MutableLiveData<List<SectionHome>>()
    var errorCode = MutableLiveData<ErrorCode>()

    fun getData(){
        callApi.getHomeData(onSuccess = {
            data.value = it
            Log.d("HomeViewModel", "data: $it")
        }, onFailure = {
            errorCode.value = it
        })
    }
}