package com.manager.singlescreenapp.model.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    const val BASE_URL = "https://github-trending-api.now.sh"
    var retrofit: Retrofit? = null

    fun  getApiClient(): Retrofit? {

        if(retrofit == null){
            retrofit = Retrofit.Builder().baseUrl(
                BASE_URL
            )
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        return retrofit
    }

}