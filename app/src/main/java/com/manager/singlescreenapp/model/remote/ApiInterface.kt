package com.manager.singlescreenapp.model.remote

import com.manager.singlescreenapp.domain.entities.Author
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/repositories")
    fun getData() : Call<List<Author>>
}