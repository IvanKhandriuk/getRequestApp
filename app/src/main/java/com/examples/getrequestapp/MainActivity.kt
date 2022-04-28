package com.examples.getrequestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.examples.getrequestapp.Data.Repository.AuthorizationRepository
import com.examples.getrequestapp.Model.Authorization.AuthorizationItem

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    lateinit var textViewMessage: TextView
    lateinit var logInButton:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textViewMessage=findViewById(R.id.textView)
        logInButton=findViewById(R.id.logInButton)

        val authorizationRepository = AuthorizationRepository()
        val viewModelFactory=MainViewModelFactory(authorizationRepository)
        viewModel= ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getAuthorizationItem()
        viewModel.myResponse2.observe(this, Observer{ response ->
            if(response.isSuccessful) {
                Log.d("Response Code", response.body()?.code.toString())
                Log.d("Response Result", response.body()?.result.toString())
                textViewMessage.text=response.body()?.code!!.toString()

            }else{
                Log.d("Response", response.errorBody().toString())
                textViewMessage.text=response.code().toString()
            }
        })
        logInButton.setOnClickListener {
            val myLogin: Unit =
            viewModel.getAuthorizationItem()
        }
    }
}