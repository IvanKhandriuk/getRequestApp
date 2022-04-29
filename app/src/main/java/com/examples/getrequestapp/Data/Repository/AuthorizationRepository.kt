package com.examples.getrequestapp.Data.Repository

import com.examples.getrequestapp.Data.Api.RetrofitInstance
import com.examples.getrequestapp.Model.Authorization.AuthorizationItem
import retrofit2.Response

class AuthorizationRepository {

    suspend fun setAuthorization(login: String,pass: String):Response<List<AuthorizationItem>>{
        return RetrofitInstance.API.setAuthorization(login, pass)
    }

    suspend fun getAuthorizationCode(): Response<AuthorizationItem> {
        return RetrofitInstance.API.getAuthorizationCode()
    }


}