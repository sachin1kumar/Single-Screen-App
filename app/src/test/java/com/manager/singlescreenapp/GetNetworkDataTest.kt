package com.manager.singlescreenapp

import com.manager.singlescreenapp.model.remote.ApiClient
import com.manager.singlescreenapp.model.remote.GetNetworkData
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock

class GetNetworkDataTest {

    @Mock
    lateinit var getNetworkData: GetNetworkData

    @Before
    fun setUp(){
        getNetworkData = GetNetworkData()
    }

    @Test
    fun getApiClientTest(){
        getNetworkData.getRemoteData()
    }

    @After
    fun tearDown(){

    }
}