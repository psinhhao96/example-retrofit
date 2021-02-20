package hutech.com.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import hutech.com.myapplication.manager.ErrorCode
import hutech.com.myapplication.manager.FirebaseManager
import hutech.com.myapplication.model.User

class MainViewModel {

    val firebaseManager : FirebaseManager = FirebaseManager()
    var user = MutableLiveData<User>()
    var errorCode = MutableLiveData<ErrorCode>()

    fun login(username : String, password : String){
        firebaseManager.login(username, password,
            onSuccess = {
            user.value = it
        }, onFailure = {
            errorCode.value = it
        })
    }

//    fun test(){
//        var student = User()
//        student.username = "ABC"
//        user.value = student
//    }

}