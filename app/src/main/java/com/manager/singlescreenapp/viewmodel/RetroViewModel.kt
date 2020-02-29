package com.manager.singlescreenapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.manager.singlescreenapp.model.Author
import com.manager.singlescreenapp.model.local.PreferenceManager
import com.manager.singlescreenapp.model.remote.GetNetworkData
import java.text.SimpleDateFormat
import java.util.*

class RetroViewModel : ViewModel() {

    fun fetchRemoteData(): LiveData<List<Author>>  {
        val getNetworkData = GetNetworkData()
        return getNetworkData.getRemoteData()
    }

    fun calculateCurrentTime(): String {
        return SimpleDateFormat("hh:mm:ss aa").format(Date())
    }

    fun updateLastTime(time: String){
        PreferenceManager.getPreferenceInstance()?.saveLastTime(time)
    }

    fun updateIsFirstFlag(){
        PreferenceManager.getPreferenceInstance()?.updateFirstTime()
    }

    fun  isFirstTimeAppLaunch(): Boolean? {
        return PreferenceManager.getPreferenceInstance()?.isFirstTime()
    }

    fun calculateTimeDifference(time: String): Int {
        val format = SimpleDateFormat("hh:mm:ss aa")
        val firstTime = format.parse(time)
        val secondTime = format.parse(PreferenceManager.getPreferenceInstance()?.getLastTime())
        val mills: Long = firstTime.time - secondTime.time
        return (mills/(1000 * 60 * 60)).toInt()
    }

    fun saveDataInLocal(data : List<Author>){
        PreferenceManager.getPreferenceInstance()?.saveDataInLocal(data)
    }

    fun getDataFromLocal(): List<Author>?{
        return PreferenceManager.getPreferenceInstance()?.getDataFromLocal()
    }
}