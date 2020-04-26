package com.manager.singlescreenapp.model

import androidx.lifecycle.LiveData
import com.manager.singlescreenapp.domain.entities.Author
import com.manager.singlescreenapp.model.local.LocalSource
import com.manager.singlescreenapp.model.remote.RemoteSource

class DataRepository(private val local: LocalSource, private val remote: RemoteSource) {

    fun getLocalData() : List<Author>? = local.getLocalData()
    fun updateLastTimeLocal(time: String) = local.updateLastTime(time)
    fun getRemoteData() : LiveData<List<Author>> = remote.getRemoteData()
}