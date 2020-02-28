package com.manager.singlescreenapp.model.local

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.manager.singlescreenapp.model.Author
import com.manager.singlescreenapp.utils.CustomApplication
import java.io.File


class PreferenceManager {

    companion object {
        //Shared Preference file name.
        private val CACH_FILE = "CUSTOM_CACHE"

        //Key name
        private val CACH_KEY = "CACHED_DATA"
        private val DATA_DIR = "/data/data/"
        private val SHARED_PREF_DIR = "/shared_prefs/"

        @Volatile
        private var mPreference: PreferenceManager? = null

        private var mSharedPreferences: SharedPreferences? = null


        fun getPreferenceInstance(): PreferenceManager? {
            synchronized(PreferenceManager::class.java) {
                if (mPreference == null) {
                    mPreference = PreferenceManager()
                }
            }
            return mPreference
        }

        @Synchronized
        fun getSharedPreference(): SharedPreferences? {
            if (mSharedPreferences == null) {
                mSharedPreferences = CustomApplication.getAppContext()
                    .getSharedPreferences(
                        CACH_FILE,
                        Context.MODE_PRIVATE
                    )
            }
            return mSharedPreferences
        }
    }

    fun saveDataInLocal(list: List<Author>?){
        getSharedPreference()?.edit()?.putString(CACH_KEY, Gson().toJson(list))?.apply()
    }

    fun getDataFromLocal(): List<Author>?{
        return Gson().fromJson(getSharedPreference()?.getString(CACH_KEY,""), null)
    }

    fun clearData() {
        try {
            getSharedPreference()?.edit()?.clear()
            getSharedPreference()?.edit()?.apply()
            val sharedPreferenceFile =
                File(DATA_DIR + CustomApplication.getAppContext().packageName.toString() + SHARED_PREF_DIR)
            val listFiles = sharedPreferenceFile.listFiles()
            for (file in listFiles) {
                file.delete()
            }
        } catch (e: Exception) {}
    }

}