package com.abecerra.feature_characters.utils.serviceMock

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.net.HttpURLConnection

object MockWebServerController {

    private val mockWebServer: MockWebServer = MockWebServer()

    fun <T> buildMockedService(service: Class<T>): T {
        mockWebServer.start()
        return Retrofit.Builder()
            .baseUrl(mockWebServer.url("/"))
            .addConverterFactory(MoshiConverterFactory.create())
            .client(OkHttpClient())
            .build()
            .create(service)
    }

    fun setUpOkResponseWithBody(body: String) {
        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(body)
        mockWebServer.enqueue(response)
    }

    fun shutDown() {
        mockWebServer.shutdown()
    }
}