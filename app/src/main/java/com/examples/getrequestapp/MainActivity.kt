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
    lateinit var logOutButton:Button


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
            val myLogIn=userNameEditText.text.toString()
            val myPassWord=passwordEditText.text.toString()
            Log.d("name", myLogIn)
            val encodePass:String=Base64.getEncoder().encodeToString(myPassWord.toByteArray())
            viewModel.setAuthorization(myLogIn,encodePass)

        viewModel.myResponse.observe(this, Observer{ response->
            if(response.isSuccessful) {
                Log.d("Response", response.body()?.code.toString())
                resultTextView.text=response.body()?.code!!
                Log.d("Response", response.body()?.result.toString())
            }
        })
        }
//        logOutButton.setOnClickListener {
//            viewModel.logOut("-1259379335")}
//-1259379335
    }
}