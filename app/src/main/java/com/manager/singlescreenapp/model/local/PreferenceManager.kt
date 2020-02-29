package com.manager.singlescreenapp.model.local

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.manager.singlescreenapp.model.Author
import com.manager.singlescreenapp.utils.CustomApplication
import com.manager.singlescreenapp.utils.Util
import java.lang.reflect.Type

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
        val type: Type = object : TypeToken<List<Author>?>() {}.getType()
        return Gson().fromJson(getSharedPreference()?.getString( Util.CACH_KEY,""), type)
    }

    fun isFirstTime(): Boolean? {
        return getSharedPreference()?.getBoolean(Util.IS_FIRST_TIME,true)
    }

    fun updateFirstTime() {
        getSharedPreference()?.edit()?.putBoolean(Util.IS_FIRST_TIME,false)?.apply()
    }

    fun saveLastTime(time: String){
        getSharedPreference()?.edit()?.putString(Util.LAST_TIME,time)?.apply()
    }

    fun getLastTime(): String? {
        return getSharedPreference()?.getString(Util.LAST_TIME,"")
    }

}