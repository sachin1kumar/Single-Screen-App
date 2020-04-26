package com.manager.singlescreenapp.model.local

import com.manager.singlescreenapp.domain.entities.Author

class Local : LocalSource {

    override fun getLocalData(): List<Author>? {
        return PreferenceManager.getPreferenceInstance()?.getDataFromLocal()
    }

    override fun updateLastTime(time: String) {
        PreferenceManager.getPreferenceInstance()?.saveLastTime(time)
    }
}