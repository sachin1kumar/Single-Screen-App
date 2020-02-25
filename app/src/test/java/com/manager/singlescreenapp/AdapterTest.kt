package com.manager.singlescreenapp

import androidx.constraintlayout.widget.ConstraintLayout
import com.manager.singlescreenapp.model.Author
import com.manager.singlescreenapp.view.adapters.Adapter
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.shadows.ShadowLooper

@RunWith(RobolectricTestRunner::class)
class AdapterTest {

    lateinit var list: List<Author>

    lateinit var adapter: Adapter

    lateinit var holder: Adapter.RecViewHolder

    @Before
    fun setUp() {
        ShadowLooper.runUiThreadTasksIncludingDelayedTasks()
        list = ArrayList()
        adapter = Adapter(list, RuntimeEnvironment.application)
        initHolder()
    }

    private fun initHolder() {
        try {
            holder = adapter.onCreateViewHolder(ConstraintLayout(RuntimeEnvironment.application),0)
        } catch (e:Exception){}
    }

    @Test
    fun onCreateViewHolderTest() {
        try {
            adapter.onCreateViewHolder(ConstraintLayout(RuntimeEnvironment.application),0)
        } catch (e:Exception){}
    }

    @Test
    fun onBindViewHolderTest(){
        try {
            adapter.onBindViewHolder(holder,0)
        } catch (e:Exception){}
    }

    @Test
    fun getItemCountTest(){
        adapter.itemCount
    }

    @After
    fun tearDown() {
    }
}