package com.examples.getrequestapp.Data.Api

import com.examples.getrequestapp.Model.Authorization.AuthorizationItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

//ev_auth.php?login=login&pass=base64(pass)
interface ApiAuthorization {
    @GET("ev_auth.php")
    suspend fun setAuthorization (
        @Query("login")login: String,
        @Query("pass")pass: String):Response <List<AuthorizationItem>>


    @GET("ev_auth.php")
    suspend fun getAuthorizationCode(): Response<AuthorizationItem>



}