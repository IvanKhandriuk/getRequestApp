package com.examples.getrequestapp.Data.Api

import com.examples.getrequestapp.Util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofitEnergy by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val API:ApiAuthorization by lazy{
        retrofitEnergy.create(ApiAuthorization::class.java)
    }
}