package com.manager.singlescreenapp

import com.manager.singlescreenapp.model.Author
import com.manager.singlescreenapp.view.MainActivity
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.powermock.reflect.Whitebox.invokeMethod
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.shadows.ShadowLooper

@RunWith(RobolectricTestRunner::class)
class MainActivityTest {

    private lateinit var mainActivity: MainActivity

    @Mock
    private val list: List<Author> = ArrayList()

    @Before
    fun setUp(){
        ShadowLooper.runUiThreadTasksIncludingDelayedTasks()
        mainActivity = Robolectric.setupActivity(MainActivity::class.java)
    }

    @Test
    fun shouldNotbeNull() {
        assertNotNull(mainActivity)
    }

    @Test
    fun setDataInAdapterTest(){
        invokeMethod<MainActivity>(mainActivity,
            "setDataInAdapter", list)
    }

}