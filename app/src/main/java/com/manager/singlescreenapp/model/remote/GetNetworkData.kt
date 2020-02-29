package com.manager.singlescreenapp.model.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.manager.singlescreenapp.model.Author
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetNetworkData {

    var remoteDataMutableList: MutableLiveData<List<Author>> = MutableLiveData()

    fun getRemoteData() : LiveData<List<Author>>{
        ApiClient.getApiClient()?.create(ApiInterface::class.java)?.getData()
            ?.enqueue(object :Callback<List<Author>>{
                override fun onFailure(call: Call<List<Author>>, t: Throwable) {
                    remoteDataMutableList.postValue(null)
                }

                override fun onResponse(call: Call<List<Author>>, response: Response<List<Author>>) {
                    var authorList = response.body()
                    remoteDataMutableList.postValue(authorList)
                }
            })
        return remoteDataMutableList
    }
}