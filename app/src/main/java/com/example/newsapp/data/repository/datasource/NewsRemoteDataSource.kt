package com.example.newsapp.data.repository.datasource

import com.example.newsapp.data.models.ApiResponse
import retrofit2.Response

interface NewsRemoteDataSource {
    suspend fun getTopHeadLines(country:String,page:Int):Response<ApiResponse>
}