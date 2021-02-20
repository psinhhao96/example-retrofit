package hutech.com.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.observe
import hutech.com.myapplication.manager.ErrorCode
import hutech.com.myapplication.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtUsername : EditText
    private lateinit var edtPassword : EditText
    private lateinit var btnLogin : Button
    private val mainViewModel : MainViewModel = MainViewModel()
    private fun initComponent(){
        edtUsername = findViewById(R.id.edt_main_username)
        edtPassword = findViewById(R.id.edt_main_password)
        btnLogin = findViewById(R.id.btn_main_login)
        btnLogin.setOnClickListener(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initComponent()
        mainViewModel.user?.observe(this){
            Log.d("MainActivity","OnCreate, User: ${it.username}")
        }
        mainViewModel.errorCode?.observe(this){
            Toast.makeText(this, it.message(), Toast.LENGTH_LONG).show()
        }


    }

    override fun onClick(p0: View?) {
        when(p0){
            btnLogin -> login()
        }
    }

    private fun login(){
        val username : String = edtUsername.text.toString().trim()
        val password : String = edtPassword.text.toString().trim()
        //Log.d("MainActivity", "login: $username$password")
        mainViewModel.login(username, password)
    }
}