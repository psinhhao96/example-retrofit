package hutech.com.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import hutech.com.myapplication.manager.CallApi
import hutech.com.myapplication.manager.ErrorCode
import hutech.com.myapplication.model.Section

class MovieViewModel {
    private val callApi : CallApi = CallApi()
    var data = MutableLiveData<List<Section>>()
    var errorCode = MutableLiveData<ErrorCode>()

    fun getData(){
        callApi.getPosterData(onSuccess = {
            data.value = it
        }, onFailure = {
            errorCode.value = it
        })
    }
}