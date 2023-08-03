package com.example.newsapp.data.repository.datasourceImpl

import com.example.newsapp.data.api.NewsApiServices
import com.example.newsapp.data.models.ApiResponse
import com.example.newsapp.data.repository.datasource.NewsRemoteDataSource
import retrofit2.Response

class NewsDataSourceImplementation(
    private val newsApiServices: NewsApiServices,
    private val country:String,
    private val page:Int
) : NewsRemoteDataSource {
    override suspend fun getTopHeadLines(): Response<ApiResponse> {
        return newsApiServices.getTopHeadLines(country,page)
    }

}