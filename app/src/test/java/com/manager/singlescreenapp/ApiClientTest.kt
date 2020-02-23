package com.manager.singlescreenapp

import com.manager.singlescreenapp.model.remote.ApiClient
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock


class ApiClientTest {

    @Mock
    val apiClient: ApiClient = ApiClient

    @Before
    fun setUp(){

    }

    @Test
    fun getApiClientTest(){
        apiClient.getApiClient()
    }

    @After
    fun tearDown(){

    }
}