package com.example.newsapp.domain.repository

import com.example.newsapp.data.models.ApiResponse
import com.example.newsapp.data.models.Article
import com.example.newsapp.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNewsHeadLines():Resource<ApiResponse>
    suspend fun getSearchNews(searchQuery:String):Resource<ApiResponse>
    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews():Flow<List<Article>>
}