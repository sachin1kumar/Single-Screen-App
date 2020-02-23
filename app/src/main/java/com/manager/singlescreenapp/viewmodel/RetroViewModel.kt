package com.manager.singlescreenapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.manager.singlescreenapp.model.Author
import com.manager.singlescreenapp.model.remote.GetNetworkData

class RetroViewModel : ViewModel() {

    var getNetworkData: GetNetworkData = GetNetworkData()
    private var remoteLiveData: LiveData<List<Author>> = MutableLiveData()

    init {
        fetchRemoteData()
    }

    private fun fetchRemoteData() {
        remoteLiveData = getNetworkData.getRemoteData()
    }
}