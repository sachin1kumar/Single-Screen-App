package com.manager.singlescreenapp

import com.manager.singlescreenapp.domain.entities.Author
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
        try {
            assertNotNull(mainActivity)
        } catch (e: Exception){}
    }

    @Test
    fun setDataInAdapterTest(){
        try {
            invokeMethod<MainActivity>(mainActivity,
                "setDataInAdapter", list)
        }catch (e:Exception){}
    }

    @Test
    fun showNoInternetFragmentTest(){
        try {
            invokeMethod<MainActivity>(mainActivity,
                "showNoInternetFragment")
        }catch (e:Exception){}
    }

    @Test
    fun removeNoInternetFragmentTest(){
        try {
            invokeMethod<MainActivity>(mainActivity,
                "removeNoInternetFragment")
        }catch (e:Exception){}
    }

    @Test
    fun onRetryTest(){
        try {
            mainActivity.onRetry()
        }catch (e: Exception){}
    }
}