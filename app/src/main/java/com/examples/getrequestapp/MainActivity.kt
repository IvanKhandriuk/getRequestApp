package com.examples.getrequestapp

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.examples.getrequestapp.Data.Repository.AuthorizationRepository
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    lateinit var resultTextView: TextView
    lateinit var userNameEditText: EditText
    lateinit var passwordEditText: EditText
    lateinit var logInButton:Button


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView=findViewById(R.id.resultTextView)
        userNameEditText=findViewById(R.id.usernameEditText)
        passwordEditText=findViewById(R.id.passwordEditText)
        logInButton=findViewById(R.id.logInButton)

        val authorizationRepository = AuthorizationRepository()
        val viewModelFactory=MainViewModelFactory(authorizationRepository)
        viewModel= ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        logInButton.setOnClickListener {
            val myLogIn:String=userNameEditText.text.toString()
            val myPassWord:String=userNameEditText.text.toString()
            val encodePass:String=Base64.getEncoder().encodeToString(myPassWord.toByteArray())
            viewModel.setAuthorization(myLogIn,encodePass)

        viewModel.myResponse2.observe(this, Observer{ response->
            if(response.isSuccessful){
                response.body()?.forEach {
                    Log.d("Response", it.code)
                    Log.d("Response", it.result)
                }
            }else{
                resultTextView.text = response.code().toString()
            }
        })
        }
    }
}