package com.examples.getrequestapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.examples.getrequestapp.Data.Repository.AuthorizationRepository
import com.examples.getrequestapp.Model.Authorization.AuthorizationItem
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.http.Query

class MainViewModel(private val repositoryAuthorization: AuthorizationRepository): ViewModel() {

    val myResponse: MutableLiveData<Response<AuthorizationItem>> = MutableLiveData()
    val myResponse2: MutableLiveData<Response<List<AuthorizationItem>>> = MutableLiveData()

    fun getAuthorizationItem(){
        viewModelScope.launch {
            val response =repositoryAuthorization.getAuthorizationCode()
            myResponse.value= response
        }
    }

    fun setAuthorization(login:String,pass:String){
        viewModelScope.launch{
            val response = repositoryAuthorization.setAuthorization(login, pass)
            myResponse2.value=response
        }
    }
}