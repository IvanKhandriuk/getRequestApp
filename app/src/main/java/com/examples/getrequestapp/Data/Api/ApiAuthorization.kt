package com.examples.getrequestapp.Data.Api

import android.widget.TextView
import com.examples.getrequestapp.Model.Authorization.AuthorizationItem
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*


//ev_auth.php?login=login&pass=base64(pass)
interface ApiAuthorization {
    @GET("ev_auth.php")
    suspend fun setAuthorization (
        @Query("login")login: String,
        @Query("pass")pass: String):Response <AuthorizationItem>

    @GET("http://e-meter.biz/deauth")
    suspend fun logOut(@Query("code")code:String):Call <AuthorizationItem>




}