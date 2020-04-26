package com.manager.singlescreenapp.model.local

import com.manager.singlescreenapp.domain.entities.Author

interface LocalSource {
    fun getLocalData(): List<Author>?
    fun updateLastTime(time: String)
}