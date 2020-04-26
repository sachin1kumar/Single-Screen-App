package com.manager.singlescreenapp.model.remote

import androidx.lifecycle.LiveData
import com.manager.singlescreenapp.domain.entities.Author

class Remote : RemoteSource {

    override fun getRemoteData(): LiveData<List<Author>> {
        val getNetworkData = GetNetworkData()
        return getNetworkData.getRemoteData()
    }
}