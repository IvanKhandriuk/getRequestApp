package com.examples.getrequestapp

import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.examples.getrequestapp.Data.Repository.AuthorizationRepository
import com.examples.getrequestapp.Model.Authorization.AuthorizationItem
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Query

class MainViewModel(private val repositoryAuthorization: AuthorizationRepository): ViewModel() {

    val myResponse: MutableLiveData<Response<AuthorizationItem>> = MutableLiveData()
    val logOutCode: MutableLiveData<Call<AuthorizationItem>> = MutableLiveData()

    fun setAuthorization(login:String,pass:String) {
        viewModelScope.launch {
            val response = repositoryAuthorization.setAuthorization(login, pass)
            myResponse.value = response
        }
    }

        fun logOut(code: String){
            viewModelScope.launch {
                val response = repositoryAuthorization.logOut(code)
                logOutCode.value = response
            }
        }
}