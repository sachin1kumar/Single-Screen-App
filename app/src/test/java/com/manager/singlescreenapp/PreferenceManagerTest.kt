package com.manager.singlescreenapp

import com.manager.singlescreenapp.model.local.PreferenceManager
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class PreferenceManagerTest {

    @Mock
    lateinit var preferenceManager: PreferenceManager

    @Before
    fun setUp(){
        preferenceManager = PreferenceManager()
    }

    @Test
    fun getPreferenceInstanceTest(){
        PreferenceManager.getPreferenceInstance()
    }

}