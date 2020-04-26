package com.manager.singlescreenapp.domain.usecases

import com.manager.singlescreenapp.domain.entities.Author
import com.manager.singlescreenapp.model.DataRepository

class GetLocalData(private val dataRepo: DataRepository) {

    fun getDataFromLocal() : List<Author>?{
        return dataRepo.getLocalData()
    }

    fun updateLastTimeLocal(time: String){
        dataRepo.updateLastTimeLocal(time)
    }

}