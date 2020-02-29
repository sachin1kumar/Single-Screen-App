package com.manager.singlescreenapp.utils

import android.app.Application
import android.content.Context

class CustomApplication : Application(){

    companion object {
        var context: Context? = null

        fun getAppContext(): Context {
            if(context == null){
                throw IllegalStateException(
                    "Trying to access app context before the application has been created."
                )
            }
            return context as Context
        }
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}