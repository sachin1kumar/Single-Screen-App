package com.manager.singlescreenapp.model.remote

import androidx.lifecycle.LiveData
import com.manager.singlescreenapp.domain.entities.Author

interface RemoteSource {
    fun getRemoteData(): LiveData<List<Author>>
}