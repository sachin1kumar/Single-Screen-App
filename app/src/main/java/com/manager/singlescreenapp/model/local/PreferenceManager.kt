package com.manager.singlescreenapp.model.local

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.manager.singlescreenapp.model.Author
import com.manager.singlescreenapp.utils.CustomApplication
import com.manager.singlescreenapp.utils.Util
import java.io.File


class PreferenceManager {

    companion object {

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
                        Util.CACH_FILE,
                        Context.MODE_PRIVATE
                    )
            }
            return mSharedPreferences
        }
    }

    fun saveDataInLocal(list: List<Author>?){
        getSharedPreference()?.edit()?.putString( Util.CACH_KEY, Gson().toJson(list))?.apply()
    }

    fun getDataFromLocal(): List<Author>?{
        return Gson().fromJson(getSharedPreference()?.getString( Util.CACH_KEY,""), null)
    }

    fun clearData() {
        try {
            getSharedPreference()?.edit()?.clear()
            getSharedPreference()?.edit()?.apply()
            val sharedPreferenceFile =
                File( Util.DATA_DIR + CustomApplication.getAppContext().packageName.toString() +  Util.SHARED_PREF_DIR)
            val listFiles = sharedPreferenceFile.listFiles()
            for (file in listFiles) {
                file.delete()
            }
        } catch (e: Exception) {}
    }

}