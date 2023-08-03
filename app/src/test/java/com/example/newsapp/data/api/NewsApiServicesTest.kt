package com.example.newsapp.data.api

import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import okio.buffer
import okio.source
import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class NewsApiServicesTest {
    private lateinit var newsApiServices: NewsApiServices
    private lateinit var mockWebServer: MockWebServer


    @Before
    fun setUp(){
       mockWebServer = MockWebServer()
       newsApiServices = Retrofit.Builder()
           .baseUrl(mockWebServer.url(""))
           .addConverterFactory(GsonConverterFactory.create())
           .build()
           .create(NewsApiServices::class.java)
    }


    private fun enqueueMockResponse(fileName:String){
        val inputStream = javaClass.classLoader!!.getResourceAsStream(fileName)
        val source = inputStream.source().buffer()
        val  mockResponse = MockResponse()
        mockResponse.setBody(source.readString(Charsets.UTF_8))
        mockWebServer.enqueue(mockResponse)
    }

    @Test
    fun getTopHeadLines_sentRequest_receivedExpected(){
        runBlocking {
            enqueueMockResponse("newsresponses.json")
            val responseBody = newsApiServices.getTopHeadLines("us", page = 1).body()
            val request = mockWebServer.takeRequest()
            assertThat(responseBody).isNotNull()
            assertThat(request.path).isEqualTo("/v2/top-headlines?country=us&page=1&apiKey=1f75169ca6fe4f6c9475024e2d9c608a")
        }
    }

    @Test
    fun getTopHeadLines_receivedResponse_correctPageSize(){
         runBlocking {
             enqueueMockResponse("newsresponses.json")
             val responseBody = newsApiServices.getTopHeadLines("us", page = 1).body()
             val articlesList = responseBody!!.articles
             assertThat(articlesList.size).isEqualTo(20)
         }
    }

    @Test
    fun getTopHeadLines_receivedResponse_correctContent(){
        runBlocking {
            enqueueMockResponse("newsresponses.json")
            val responseBody = newsApiServices.getTopHeadLines("us", page = 1).body()
            val articlesList = responseBody!!.articles
            val article = articlesList[0]
            assertThat(article.author).isEqualTo("Hannah Rabinowitz, Marshall Cohen")
            assertThat(article.url).isEqualTo("https://www.cnn.com/2023/08/01/politics/judge-tanya-chutkan-trump-indictment/index.html")
            assertThat(article.publishedAt).isEqualTo("2023-08-02T14:28:00Z")
        }
    }

    @After
    fun tearDown(){
      mockWebServer.shutdown()
    }
}