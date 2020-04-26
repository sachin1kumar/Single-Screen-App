package com.manager.singlescreenapp.domain.usecases

import androidx.lifecycle.LiveData
import com.manager.singlescreenapp.domain.entities.Author
import com.manager.singlescreenapp.model.DataRepository

class GetRemoteData(private val dataRepo: DataRepository) {

    fun getDataFromRemote() : LiveData<List<Author>>{
        return dataRepo.getRemoteData()
    }
}