package com.examples.getrequestapp.Data.Repository

import android.widget.TextView
import com.examples.getrequestapp.Data.Api.RetrofitInstance
import com.examples.getrequestapp.Model.Authorization.AuthorizationItem
import retrofit2.Call
import retrofit2.Response

class AuthorizationRepository {

    suspend fun setAuthorization(login: String,pass: String):Response<AuthorizationItem>{
        return RetrofitInstance.API.setAuthorization(login, pass)
    }

    suspend fun logOut(code: String):Call<AuthorizationItem>{
        return RetrofitInstance.API.logOut(code)
    }
}