package com.manager.singlescreenapp

import com.manager.singlescreenapp.view.MainActivity
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLooper

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    private lateinit var mainActivity: MainActivity

    @Before
    fun setUp(){
        ShadowLooper.runUiThreadTasksIncludingDelayedTasks()
        mainActivity = Robolectric.setupActivity(MainActivity::class.java)
    }

    @Test
    fun shouldNotbeNull() {
        assertNotNull(mainActivity)
    }

}