package hutech.com.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import hutech.com.myapplication.manager.CallApi
import hutech.com.myapplication.manager.ErrorCode
import hutech.com.myapplication.model.ItemMovie
import hutech.com.myapplication.model.SectionMovie

class DetailMovieViewModel {
    private val callApi : CallApi = CallApi()
    var data = MutableLiveData<List<ItemMovie>>()
    var errorCode = MutableLiveData<ErrorCode>()

    fun getData(){
        callApi.getDetailMovie(onSuccess = {
            data.value = it
        }, onFailure = {
            errorCode.value = it
        })
    }
}