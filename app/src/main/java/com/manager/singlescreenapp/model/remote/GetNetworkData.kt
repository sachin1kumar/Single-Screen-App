package com.manager.singlescreenapp.model.remote


import android.util.Log
import com.manager.singlescreenapp.model.Author
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetNetworkData {

    fun getRemoteData(){

        ApiClient.getApiClient()?.create(ApiInterface::class.java)?.getData()
            ?.enqueue(object :Callback<List<Author>>{

                override fun onFailure(call: Call<List<Author>>, t: Throwable) {
                    Log.e("Response:", "onFailure:"+call)
                }

                override fun onResponse(call: Call<List<Author>>, response: Response<List<Author>>) {
                    Log.e("Response:", response.body()?.get(0)?.author)
                }

            })
    }
}