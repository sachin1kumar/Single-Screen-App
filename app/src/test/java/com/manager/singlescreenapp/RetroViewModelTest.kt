package com.manager.singlescreenapp

import com.manager.singlescreenapp.viewmodel.RetroViewModel
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.powermock.reflect.Whitebox

class RetroViewModelTest {

    @Mock
    val retroViewModel: RetroViewModel =
        RetroViewModel()

    @Before
    fun setUp(){

    }

    @Test
    fun fetchRemoteDataTest(){
        Whitebox.invokeMethod<RetroViewModel>(retroViewModel,"fetchRemoteData")
    }

    @After
    fun tearDown(){

    }
}