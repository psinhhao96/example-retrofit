package hutech.com.myapplication.manager

import com.google.firebase.database.*
import com.google.gson.Gson
import hutech.com.myapplication.model.User


class FirebaseManager {

    var firebaseData : FirebaseDatabase = FirebaseDatabase.getInstance();
    var reference : DatabaseReference = firebaseData.reference;
    
    fun login(username : String, password : String,onSuccess: (User?) -> Unit, onFailure: (ErrorCode?) -> Unit){
        reference.child("users").child(username).addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    var user = Gson().fromJson(snapshot.value.toString(),User::class.java)
                    onSuccess(user)
                    //Log.d("FirebaseManager-login","user: "+user.toString())
                }else{
                    onFailure(ErrorCode.USERNOTEXISTS)
                }
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
                onFailure(ErrorCode.USERINCORRECT)
            }
        })
    }
}